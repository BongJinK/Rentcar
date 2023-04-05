package reservationInquiry;

import java.sql.Timestamp;

public class ResInquiry {

	private String reservationCode, vehicleVenue;
	private String vehicleCode;;
	private Timestamp regDate, reservationDate;
	private Timestamp returnDate;
	private int rentalTime, driverCode, rentalCost;

	public ResInquiry(String reservationCode, Timestamp regDate, int rentalTime, String vehicleCode, int driverCode,
			Timestamp reservationDate, Timestamp returnDate, int rentalCost, String vehicleVenue) {
		this.reservationCode = reservationCode;
		this.regDate = regDate;
		this.rentalTime = rentalTime;
		this.vehicleCode = vehicleCode;
		this.driverCode = driverCode;
		this.reservationDate = reservationDate;
		this.returnDate = returnDate;
		this.rentalCost = rentalCost;
		this.vehicleVenue = vehicleVenue;
	}

	public String getReservationCode() {
		return reservationCode;
	}

	public String getVehicleVenue() {
		return vehicleVenue;
	}

	public String getVehicleCode() {
		return vehicleCode;
	}

	public Timestamp getRegDate() {
		return regDate;
	}

	public Timestamp getReservationDate() {
		return reservationDate;
	}

	public Timestamp getReturnDate() {
		return returnDate;
	}

	public int getRentalTime() {
		return rentalTime;
	}

	public int getDriverCode() {
		return driverCode;
	}

	public int getRentalCost() {
		return rentalCost;
	}

}
