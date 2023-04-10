package reservation;

import java.sql.Timestamp;

public class Reservation {

	private String reservationCode;
	private Timestamp regDate;
	private int rentalTime;
	private String clientId;
	private String clientName;
	private String vehicleCode;
	private String driverCode;
	private Timestamp reservationDate;
	private Timestamp returnDate;
	private String rentCost;
	private String vehicleVenue;

	public Reservation(String reservationCode, Timestamp regDate, int rentalTime, String clientId, String clientName,
			String vehicleCode, String driverCode, Timestamp reservationDate, Timestamp returnDate, String rentCost,
			String vehicleVenue) {
		this.reservationCode = reservationCode;
		this.regDate = regDate;
		this.rentalTime = rentalTime;
		this.clientId = clientId;
		this.clientName = clientName;
		this.vehicleCode = vehicleCode;
		this.driverCode = driverCode;
		this.reservationDate = reservationDate;
		this.returnDate = returnDate;
		this.rentCost = rentCost;
		this.vehicleVenue = vehicleVenue;
	}

	public String getReservationCode() {
		return reservationCode;
	}

	public Timestamp getRegDate() {
		return regDate;
	}

	public int getRentalTime() {
		return rentalTime;
	}

	public String getVehicleCode() {
		return vehicleCode;
	}

	public String getClientId() {
		return clientId;
	}

	public String getClientName() {
		return clientName;
	}

	public String getDriverCode() {
		return driverCode;
	}

	public Timestamp getReservationDate() {
		return reservationDate;
	}

	public Timestamp getReturnDate() {
		return returnDate;
	}

	public String getRentCost() {
		return rentCost;
	}

	public String getVehicleVenue() {
		return vehicleVenue;
	}

}
