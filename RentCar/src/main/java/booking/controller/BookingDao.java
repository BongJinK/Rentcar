package booking.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;

import booking.BookingRequestDto;
import util.DBManager;
import vehicle.VehicleRequestDto;

public class BookingDao {

	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	private BookingDao() {
	}

	private static BookingDao instance = new BookingDao();

	public static BookingDao getInstance() {
		return instance;
	}

	// C
	public void createBooking(BookingRequestDto bookingDto) {
		this.conn = DBManager.getConnection();

		if (this.conn != null) {
			String sql = "INSERT INTO booking (book_date, rental_time, return_date, ";
			sql += "client_id, driver_code, vehicle_code) VALUES (?, ?, ?, ?, ?, ?)";

			try {
				this.pstmt = this.conn.prepareStatement(sql);
				this.pstmt.setTimestamp(1, bookingDto.getBookingDate(), Calendar.getInstance());
				this.pstmt.setInt(2, bookingDto.getRentalTime());
				System.out.println("bookingDto.getRentalTime() : " + bookingDto.getRentalTime());
				this.pstmt.setTimestamp(3, bookingDto.getReturnDate(), Calendar.getInstance());
				this.pstmt.setString(4, bookingDto.getClientId());
				this.pstmt.setString(5, bookingDto.getDriverCode());
				this.pstmt.setString(6, bookingDto.getVehicleCode());

				this.pstmt.execute();

			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt);
			}
		}
	}

	// R

	// U

	// D

}
