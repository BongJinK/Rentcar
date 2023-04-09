package vehicle.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;

import util.DBManager;
import vehicle.Vehicle;
import vehicle.VehicleRequestDto;

public class VehicleDao {

	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	private VehicleDao() {
	}

	private static VehicleDao instance = new VehicleDao();

	public static VehicleDao getInstance() {
		return instance;
	}

	// C
	public void createVehicle(VehicleRequestDto vehicleDto) {
		this.conn = DBManager.getConnection();

		if (this.conn != null) {
			String sql = "INSERT INTO vehicle (vehicle_code, vehicle_name,";
			sql += "hourly_rate, venue_code) VALUES (?,?,?,?)";

			try {
				this.pstmt = this.conn.prepareStatement(sql);
				this.pstmt.setString(2, vehicleDto.getVehicleCode());
				this.pstmt.setString(3, vehicleDto.getVehicleName());
				this.pstmt.setInt(1, vehicleDto.getHourlyRate());
				this.pstmt.setString(4, vehicleDto.getVenueCode());

				this.pstmt.execute();

			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt);
			}
		}
	}

	// R
	// 전체 검색
	public ArrayList<Vehicle> getVehicleAll() {
		ArrayList<Vehicle> list = new ArrayList<>();
		this.conn = DBManager.getConnection();

		if (this.conn != null) {
			String sql = "SELECT * FROM vehicle ORDER BY vehicle_name";

			try {
				this.pstmt = this.conn.prepareStatement(sql);
				this.rs = this.pstmt.executeQuery();

				while (this.rs.next()) {
					String vehicleCode = this.rs.getString(1);
					String vehicleNmae = this.rs.getString(2);
					int hourlyRate = this.rs.getInt(3);
					String venueCode = this.rs.getString(4);
					Timestamp regDate = this.rs.getTimestamp(5, Calendar.getInstance());

					Vehicle vehicle = new Vehicle(vehicleCode, vehicleNmae, hourlyRate, venueCode, regDate);

					list.add(vehicle);
				}

			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt, rs);
			}
		}
		return list;
	}

	// 차량 검색// 삭제 고려
	public ArrayList<Vehicle> getVehicleByKeyword(String keyword) {
		ArrayList<Vehicle> list = new ArrayList<>();
		this.conn = DBManager.getConnection();

		if (this.conn != null) {
			String sql = "SELECT vehicle_code,vehicle_name,hourly_rate,venue_code FROM vehicle";
			sql += " WHERE vehicle_name LIKE ?";

			try {
				String key = "%" + keyword + "%";
				this.pstmt = this.conn.prepareStatement(sql);
				this.pstmt.setString(1, key);
				this.pstmt.setString(2, key);

				this.rs = this.pstmt.executeQuery();

				while (this.rs.next()) {
					String vehicleCode = this.rs.getString(1);
					String vehicleNmae = this.rs.getString(2);
					int hourlyRate = this.rs.getInt(3);
					String venueCode = this.rs.getString(4);

					Vehicle vehicle = new Vehicle(vehicleCode, vehicleNmae, hourlyRate, venueCode);
					list.add(vehicle);
				}

			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt, rs);
			}
		}
		return list;
	}

	// U
	public void updateClient(VehicleRequestDto vehicleDto) {
		this.conn = DBManager.getConnection();

		if (this.conn != null) {
			String sql = "UPDATE vehicle SET vehicle_name = ?,hourly_rate = ?";
			sql += "venue_code = ? WHERE vehicle_code = ?";

			try {
				this.pstmt = this.conn.prepareStatement(sql);
				this.pstmt.setString(1, vehicleDto.getVehicleName());
				this.pstmt.setInt(2, vehicleDto.getHourlyRate());
				this.pstmt.setString(3, vehicleDto.getVenueCode());
				this.pstmt.setString(4, vehicleDto.getVehicleCode());

				this.pstmt.execute();

			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt);
			}
		}
	}

	// D
	public void deleteClientById(String vehicle_code) {
		this.conn = DBManager.getConnection();

		if (this.conn != null) {
			String sql = "DELETE FROM vehicle WHERE vehicle_code = ?";

			try {
				this.pstmt = this.conn.prepareStatement(sql);
				this.pstmt.setString(1, vehicle_code);

				this.pstmt.execute();

			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt);
			}
		}
	}

}
