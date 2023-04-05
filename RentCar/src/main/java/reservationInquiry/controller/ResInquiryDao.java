package reservationInquiry.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import client.Client;
import client.controller.ClientDao;
import util.DBManager;

public class ResInquiryDao {

	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	private ResInquiryDao() {
	}

	private static ResInquiryDao instance = new ResInquiryDao();

	public static ResInquiryDao getInstance() {
		return instance;
	}

	private Client getClient(String id) {
		Client client = null;
		client = ClientDao.getInstance().getClientById(id);

		return client;
	}

	public ArrayList<Object[]> getReservationByClientId(String id) {
		ArrayList<Object[]> list = null;

		this.conn = DBManager.getConnection();

		Client client = getClient(id);

		if (this.conn != null && client != null) {
			list = new ArrayList<Object[]>();
			int driver_code = client.getDriverCode();
			String sql = "SELECT * FROM reservation_info where driver_code = ?";

			try {
				this.pstmt = this.conn.prepareStatement(sql);
				this.pstmt.setInt(1, driver_code);

				this.rs = this.pstmt.executeQuery();

				while (this.rs.next()) {
					Object[] temp = new Object[9];

					String reservationCode = this.rs.getString(1);
					Timestamp regDate = this.rs.getTimestamp(2);
					int rentalTime = this.rs.getInt(3);
					String vehicleCode = this.rs.getString(4);
					int driverCode = this.rs.getInt(5);
					Timestamp reservationDate = this.rs.getTimestamp(6);
					Timestamp returnDate = this.rs.getTimestamp(7);
					int rentalCost = this.rs.getInt(8);
					String vehicleVenue = this.rs.getString(9);

					temp[0] = reservationCode;
					temp[1] = regDate;
					temp[2] = rentalTime;
					temp[3] = vehicleCode;
					temp[4] = driverCode;
					temp[5] = reservationDate;
					temp[6] = returnDate;
					temp[7] = rentalCost;
					temp[8] = vehicleVenue;
					list.add(temp);
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
