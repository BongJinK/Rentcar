package reservation.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;

import reservation.Reservation;
import util.DBManager;

public class ReservationDao {
	
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private ReservationDao() {}
	private static ReservationDao instance = new ReservationDao();
	public static ReservationDao getInstance() {
		return instance;
	}
	
	//R
	// 전체 예약 정보
	public ArrayList<Reservation> getBookingAll() {
		ArrayList<Reservation> list = new ArrayList<>();
		this.conn = DBManager.getConnection();

		if (this.conn != null) {
			String sql = "SELECT * FROM reservation_info";

			try {
				this.pstmt = this.conn.prepareStatement(sql);
				this.rs = this.pstmt.executeQuery();

				while (this.rs.next()) {
					String reservationCode = this.rs.getString(1);
					Timestamp regDate = this.rs.getTimestamp(2, Calendar.getInstance());
					int rentalTime = this.rs.getInt(3);
					String clientId = this.rs.getString(4);
					String clientName = this.rs.getString(5);
					String vehicleCode = this.rs.getString(6);
					String driverCode = this.rs.getString(7);
					Timestamp reservationDate = this.rs.getTimestamp(8, Calendar.getInstance());
					Timestamp returnDate = this.rs.getTimestamp(9, Calendar.getInstance());
					String rentCost = this.rs.getString(10);
					String vehicleVenue = this.rs.getString(11);

					Reservation reservation = new Reservation(reservationCode, regDate, rentalTime, vehicleCode,
							clientId, clientName, driverCode, reservationDate, returnDate, rentCost, vehicleVenue);
					list.add(reservation);
				}

			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt, rs);
			}
		}
		return list;
	}

	// 개인 예약정보
	public ArrayList<Reservation> getBookingByClientId(String id) {
		ArrayList<Reservation> list = new ArrayList<>();
		this.conn = DBManager.getConnection();

		if (this.conn != null) {
			String sql = "SELECT * FROM test.reservation_info where client_id = ?";

			try {
				this.pstmt = this.conn.prepareStatement(sql);
				this.pstmt.setString(1, id);
				this.rs = this.pstmt.executeQuery();

				while (this.rs.next()) {
					String reservationCode = this.rs.getString(1);
					Timestamp regDate = this.rs.getTimestamp(2, Calendar.getInstance());
					int rentalTime = this.rs.getInt(3);
					String clientName = this.rs.getString(5);
					String vehicleCode = this.rs.getString(6);
					String driverCode = this.rs.getString(7);
					Timestamp reservationDate = this.rs.getTimestamp(8, Calendar.getInstance());
					Timestamp returnDate = this.rs.getTimestamp(9, Calendar.getInstance());
					String rentCost = this.rs.getString(10);
					String vehicleVenue = this.rs.getString(11);

					Reservation reservation = new Reservation(reservationCode, regDate, rentalTime, vehicleCode, id,
							clientName, driverCode, reservationDate, returnDate, rentCost, vehicleVenue);
					list.add(reservation);
				}

			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt, rs);
			}
		}
		return list;
	}
	
}
