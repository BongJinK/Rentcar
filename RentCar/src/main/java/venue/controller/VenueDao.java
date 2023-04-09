package venue.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;

import util.DBManager;
import venue.Venue;
import venue.VenueRequedyDto;

public class VenueDao {

	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	private VenueDao() {
	}

	private static VenueDao instance = new VenueDao();

	public static VenueDao getInstance() {
		return instance;
	}

	// C
	public void createVenue(VenueRequedyDto venueDao) {
		this.conn = DBManager.getConnection();

		if (this.conn != null) {
			String sql = "INSERT INTO venue (venue_code, venue_name) VALUES ( ?, ?);";

			try {
				this.pstmt = this.conn.prepareStatement(sql);
				this.pstmt.setString(1, venueDao.getVenueCode());
				this.pstmt.setString(2, venueDao.getVenueName());

				this.pstmt.execute();

			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt);
			}
		}
	}

	// R
	public ArrayList<Venue> getVenueAll( ) {
		ArrayList<Venue> list = new ArrayList<>();
		this.conn = DBManager.getConnection();

		if (this.conn != null) {
			String sql = "SELECT * FROM venue order by venue_code";

			try {
				this.pstmt = this.conn.prepareStatement(sql);
				this.rs = this.pstmt.executeQuery();

				while (this.rs.next()) {
					String venueCode = this.rs.getString(1);
					String venueName = this.rs.getString(2);
					Timestamp regDate = this.rs.getTimestamp(3, Calendar.getInstance());

					Venue venue = new Venue(venueCode, venueName, regDate);
					list.add(venue);
				}

			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt, rs);
			}
		}
		return list;
	}
	
	
	public ArrayList<Venue> getVenueAllByKeyword(String keyword) {
		ArrayList<Venue> list = new ArrayList<>();
		this.conn = DBManager.getConnection();

		if (this.conn != null) {
			String sql = "SELECT * FROM venue WHERE venue_name LIKE ?";

			try {
				String key = "%" + keyword + "%";
				this.pstmt = this.conn.prepareStatement(sql);
				this.pstmt.setString(1, key);

				this.rs = this.pstmt.executeQuery();

				while (this.rs.next()) {
					String venueCode = this.rs.getString(1);
					String venueName = this.rs.getString(2);
					Timestamp regDate = this.rs.getTimestamp(3, Calendar.getInstance());

					Venue venue = new Venue(venueCode, venueName, regDate);
					list.add(venue);
				}

			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt, rs);
			}
		}
		return list;
	}
	
	public String getVenueNameByCode(String venueCode) {
		String name = "";
		this.conn = DBManager.getConnection();

		if (this.conn != null) {
			String sql = "SELECT venue_name FROM venue WHERE venue_code = ?";

			try {
				this.pstmt = this.conn.prepareStatement(sql);
				this.pstmt.setString(1, venueCode);
				
				this.rs = this.pstmt.executeQuery();

				if (this.rs.next()) {
					name = this.rs.getString(1);
				}

			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt, rs);
			}
		}
		return name;
	}

	// U
	public void updateVenue(VenueRequedyDto venueDto) {
		this.conn = DBManager.getConnection();

		if (this.conn != null) {
			String sql = "UPDATE venue SET venue_name=? WHERE venue_code=?";

			try {
				pstmt = this.conn.prepareStatement(sql);
				pstmt.setString(1, venueDto.getVenueName());
				pstmt.setString(2, venueDto.getVenueCode());
				System.out.println("pstmt" + pstmt);

				int resultInt = pstmt.executeUpdate();
				System.out.println("resultInt ==> " + resultInt);

			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt);
			}
		}
	}

	// D
	public void deleteBoardtByBoardNum(String venueCode) {
		this.conn = DBManager.getConnection();

		if (this.conn != null) {
			String sql = "DELETE FROM venue WHERE venue_code=?";

			try {
				this.pstmt = this.conn.prepareStatement(sql);
				this.pstmt.setString(1, venueCode);

				this.pstmt.execute();

			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt);
			}
		}
	}
}
