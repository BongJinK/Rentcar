package booking;

import java.sql.Timestamp;

public class BookingRequestDto {

	private String bookingCode;
	private Timestamp regDate;
	private int rentalTime;
	private Timestamp bookingDate;
	private Timestamp returnDate;

	private String clientId;
	private String driverCode;
	private String vehicleCode;

	public BookingRequestDto(String bookingCode, Timestamp regDate, int rentalTime, String clientId,
			Timestamp bookingDate, Timestamp returnDate, String driverCode, String vehicleCode) {
		this.bookingCode = bookingCode;
		this.regDate = regDate;
		this.rentalTime = rentalTime;
		this.bookingDate = bookingDate;
		this.returnDate = returnDate;
		this.driverCode = driverCode;
		this.vehicleCode = vehicleCode;
	}

	public BookingRequestDto(int rentalTime, String clientId, Timestamp bookingDate, Timestamp returnDate,
			String driverCode, String vehicleCode) {
		this.rentalTime = rentalTime;
		this.clientId = clientId;
		this.bookingDate = bookingDate;
		this.returnDate = returnDate;
		this.driverCode = driverCode;
		this.vehicleCode = vehicleCode;
	}

	public String getBookingCode() {
		return bookingCode;
	}

	public Timestamp getRegDate() {
		return regDate;
	}

	public int getRentalTime() {
		return rentalTime;
	}

	public void setRentalTime(int rentalTime) {
		this.rentalTime = rentalTime;
	}

	public String getClientId() {
		return this.clientId;
	}

	public Timestamp getBookingDate() {
		return bookingDate;
	}

	public void setCreatedDate(Timestamp bookingDate) {
		this.bookingDate = bookingDate;
	}

	public Timestamp getReturnDate() {
		return returnDate;
	}

	public void setModifiedDate(Timestamp returnDate) {
		this.returnDate = returnDate;
	}

	public String getDriverCode() {
		return driverCode;
	}

	public void setDriverCode(String driverCode) {
		this.driverCode = driverCode;
	}

	public String getVehicleCode() {
		return vehicleCode;
	}

	public void setVehicleCode(String vehicleCode) {
		this.vehicleCode = vehicleCode;
	}

}
