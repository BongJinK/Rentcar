package vehicle;

import java.sql.Timestamp;

public class VehicleRequestDto {

	private String vehicleCode, vehicleName;
	private int hourlyRate;
	private String venueCode;
	private Timestamp regDate;

	private String venue_name;

	public VehicleRequestDto(String vehicleCode, String vehicleName, int hourlyRate, String venueCode,
			Timestamp regDate, String venue_name) {
		this.vehicleCode = vehicleCode;
		this.vehicleName = vehicleName;
		this.hourlyRate = hourlyRate;
		this.venueCode = venueCode;
		this.regDate = regDate;
		this.venue_name = venue_name;
	}

	public String getVenue_name() {
		return venue_name;
	}

	public String getVehicleCode() {
		return vehicleCode;
	}

	public void setVehicleCode(String vehicleCode) {
		this.vehicleCode = vehicleCode;
	}

	public String getVehicleName() {
		return vehicleName;
	}

	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}

	public int getHourlyRate() {
		return hourlyRate;
	}

	public void setHourlyRate(int hourlyRate) {
		this.hourlyRate = hourlyRate;
	}

	public String getVenueCode() {
		return venueCode;
	}

	public void setVenueCode(String venueCode) {
		this.venueCode = venueCode;
	}

	public Timestamp getRegDate() {
		return regDate;
	}

	public void setRegDate(Timestamp regDate) {
		this.regDate = regDate;
	}

}
