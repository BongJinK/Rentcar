package vehicle;

import java.sql.Timestamp;

public class VehicleRequestDto {

	private String vehicleCode, vehicleName;
	private int hourlyRate;
	private String venueCode;
	private Timestamp regDate;
	
	public VehicleRequestDto(String vehicleCode, String vehicleName, int hourlyRate, String venueCode, Timestamp regDate) {
		this.vehicleCode = vehicleCode;
		this.vehicleName = vehicleName;
		this.hourlyRate = hourlyRate;
		this.venueCode = venueCode;
		this.regDate = regDate;
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
