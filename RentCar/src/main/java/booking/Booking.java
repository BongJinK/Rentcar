package booking;

import java.sql.Timestamp;

public class Booking {

	private String bookingCode;
	private Timestamp regDate;
	private int rentalTime;
	private Timestamp bookingDate;
	private Timestamp returnDate;

	private String clientId;
	private String driverCode;
	private String vehicleCode;

	public Booking(String bookingCode, Timestamp regDate, int rentalTime, String clientId, Timestamp bookingDate,
			Timestamp returnDate, String driverCode, String vehicleCode) {
		this.bookingCode = bookingCode;
		this.regDate = regDate;
		this.rentalTime = rentalTime;
		this.bookingDate = bookingDate;
		this.returnDate = returnDate;
		this.driverCode = driverCode;
		this.vehicleCode = vehicleCode;
	}
	
	public Booking(BookingRequestDto bookingDto) {
		this.bookingCode = bookingDto.getBookingCode();
		this.regDate = bookingDto.getRegDate();
		this.rentalTime = bookingDto.getRentalTime();
		this.bookingDate = bookingDto.getBookingDate();
		this.returnDate = bookingDto.getReturnDate();
		this.driverCode = bookingDto.getDriverCode();
		this.vehicleCode = bookingDto.getVehicleCode();
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
	
	public String getClientId() {
		return clientId;
	}

	public Timestamp getBookingDate() {
		return bookingDate;
	}

	public Timestamp getReturnDate() {
		return returnDate;
	}

	public String getDriverCode() {
		return driverCode;
	}

	public String getVehicleCode() {
		return vehicleCode;
	}

}
