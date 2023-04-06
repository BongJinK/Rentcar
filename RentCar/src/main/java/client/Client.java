package client;

import java.sql.Timestamp;

public class Client {
	
	private String driverCode;
	private String id, password, name;
	private String address, phone;
	private Timestamp regDate;
	
	public Client(String driverCode, String id, String password, String name, String phone, String address) {
		this.driverCode = driverCode;
		this.id = id;
		this.password = password;
		this.name = name;
		this.phone = phone;
		this.address = address;
	}
	
	public Client(String driverCode, String id, String password, String name, String phone, String address, Timestamp regDate) {
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

	public String getDriverCode() {
		return driverCode;
	}

	public String getPhone() {
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
