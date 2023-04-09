package vehicle;

import java.sql.Timestamp;

public class Vehicle {

	private String vehicleCode, vehicleName;
	private int hourlyRate;
	private String venueCode;
	private Timestamp regDate;
	
	public Vehicle(String vehicleCode, String vehicleName, int hourlyRate, String venueCode, Timestamp regDate) {
		this.vehicleCode = vehicleCode;
		this.vehicleName = vehicleName;
		this.hourlyRate = hourlyRate;
		this.venueCode = venueCode;
		this.regDate = regDate;
	}
	
	public Vehicle(String vehicleCode, String vehicleName, int hourlyRate, String venueCode) {
		this.vehicleCode = vehicleCode;
		this.vehicleName = vehicleName;
		this.hourlyRate = hourlyRate;
		this.venueCode = venueCode;
	}
	
	public Vehicle(VehicleRequestDto vehicleDto) {
		this.vehicleCode = vehicleDto.getVehicleCode();
		this.vehicleName = vehicleDto.getVehicleName();
		this.hourlyRate = vehicleDto.getHourlyRate();
		this.venueCode = vehicleDto.getVenueCode();
		this.regDate = vehicleDto.getRegDate();
	}

	public String getVehicleCode() {
		return vehicleCode;
	}

	public String getVehicleName() {
		return vehicleName;
	}

	public int getHourlyRate() {
		return hourlyRate;
	}

	public String getVenueCode() {
		return venueCode;
	}

	public Timestamp getRegDate() {
		return regDate;
	}
	
}
