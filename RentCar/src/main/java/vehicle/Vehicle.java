package vehicle;

import java.sql.Timestamp;

public class Vehicle {

	private String vehicleCode, vehicleName;
	private int hourlyRate;
	private String venueCode;
	private Timestamp regDate;
	
	private String venue_name;
	
	public Vehicle(String vehicleCode, String vehicleName, int hourlyRate, String venueCode, Timestamp regDate, String venue_name) {
		this.vehicleCode = vehicleCode;
		this.vehicleName = vehicleName;
		this.hourlyRate = hourlyRate;
		this.venueCode = venueCode;
		this.regDate = regDate;
		this.venue_name = venue_name;
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
	
	public String getVenue_name() {
		return venue_name;
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
