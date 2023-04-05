package vehicle.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class VehicleDao {
	
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private VehicleDao() {}
	
	private static VehicleDao instance = new VehicleDao();
	
	public static VehicleDao getInstance() {
		return instance;
	}
	
	// C
	
	// R
	
	// U
	
	// D
	
}
