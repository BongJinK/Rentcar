package client;

import java.sql.Timestamp;

public class ClientRequestDto {

	private int driverCode, phone;
	private String id, password, name;
	private String address;
	private Timestamp regDate;

	public ClientRequestDto(int driverCode, String id, String password, String name, int phone, String address) {
		this.driverCode = driverCode;
		this.id = id;
		this.password = password;
		this.name = name;
		this.phone = phone;
		this.address = address;
	}

	public int getDriverCode() {
		return driverCode;
	}

	public void setDriverCode(int driverCode) {
		this.driverCode = driverCode;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Timestamp getRegDate() {
		return regDate;
	}
	
}
