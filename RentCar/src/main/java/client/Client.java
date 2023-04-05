package client;

import java.sql.Timestamp;

public class Client {
	
	private int driverCode, phone;
	private String id, password, name;
	private String address;
	private Timestamp regDate;
	
	public Client(int driverCode, String id, String password, String name, int phone, String address) {
		this.driverCode = driverCode;
		this.id = id;
		this.password = password;
		this.name = name;
		this.phone = phone;
		this.address = address;
	}
	
	public Client(int driverCode, String id, String password, String name, int phone, String address, Timestamp regDate) {
		this.driverCode = driverCode;
		this.id = id;
		this.password = password;
		this.name = name;
		this.phone = phone;
		this.address = address;
		this.regDate = regDate;
	}
	
	public Client(ClientRequestDto clientDto) {
		this.driverCode = clientDto.getDriverCode();
		this.id = clientDto.getId();
		this.password = clientDto.getPassword();
		this.name = clientDto.getName();
		this.phone = clientDto.getPhone();
		this.address = clientDto.getAddress();
	}

	public int getDriverCode() {
		return driverCode;
	}

	public int getPhone() {
		return phone;
	}

	public String getId() {
		return id;
	}

	public String getPassword() {
		return password;
	}

	public String getName() {
		return name;
	}

	public String getAddress() {
		return address;
	}

	public Timestamp getRegDate() {
		return regDate;
	}
	
}
