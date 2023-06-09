package client.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;

import client.Client;
import client.ClientRequestDto;
import util.DBManager;

public class ClientDao {
	
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	private ClientDao() {
	}

	private static ClientDao instance = new ClientDao();

	public static ClientDao getInstance() {
		return instance;
	}

	// C
	public void createClient(ClientRequestDto clientDto) {
		Client client = new Client(clientDto);

		this.conn = DBManager.getConnection();
		if (this.conn != null) {
			String sql = "INSERT INTO client (driver_code, client_id, password, client_name, phone, address)";
			sql += " VALUES (?, ?, ?, ?, ?, ?)";

			try {
				this.pstmt = this.conn.prepareStatement(sql);
				this.pstmt.setString(1, client.getDriverCode());
				this.pstmt.setString(2, client.getId());
				this.pstmt.setString(3, client.getPassword());
				this.pstmt.setString(4, client.getName());
				this.pstmt.setString(5, client.getPhone());
				this.pstmt.setString(6, client.getAddress());

				this.pstmt.execute();

			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt);
			}
		}
	}

	// R
	public ArrayList<Client> getClientAll() {
		ArrayList<Client> list = new ArrayList<>();
		this.conn = DBManager.getConnection();

		if (this.conn != null) {
			String sql = "SELECT * FROM client ORDER BY reg_date ASC";

			try {
				this.pstmt = this.conn.prepareStatement(sql);
				this.rs = this.pstmt.executeQuery();

				while (this.rs.next()) {
					String driverCode = this.rs.getString(1);
					String id = this.rs.getString(2);
					String password = this.rs.getString(3);
					String name = this.rs.getString(4);
					String phone = this.rs.getString(5);
					String address = this.rs.getString(6);
					Timestamp regDate = this.rs.getTimestamp(7, Calendar.getInstance());

					Client client = new Client(driverCode, id, password, name, phone, address, regDate);

					list.add(client);
				}

			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt, rs);
			}
		}
		return list;
	}

	// 본인 개인정보 조회 용도
	public Client getClientById(String id) {
		Client client = null;
		this.conn = DBManager.getConnection();

		if (this.conn != null) {
			String sql = "SELECT * FROM client_info WHERE 아이디 = ? ";

			try {
				this.pstmt = this.conn.prepareStatement(sql);
				this.pstmt.setString(1, id);
				this.rs = this.pstmt.executeQuery();

				if (this.rs.next()) {
					String driverCode = this.rs.getString(1);
					String clientId = this.rs.getString(2);
					String password = this.rs.getString(3);
					String name = this.rs.getString(4);
					String phone = this.rs.getString(5);
					String address = this.rs.getString(6);

					client = new Client(driverCode, clientId, password, name, phone, address);
				}

			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt, rs);
			}
		}
		return client;
	}
	
	//관리자 계정 정보
	public Client getClientByIdforAD(String id) {
		Client client = null;
		this.conn = DBManager.getConnection();

		if (this.conn != null) {
			String sql = "SELECT * FROM client WHERE client_id = ?";

			try {
				this.pstmt = this.conn.prepareStatement(sql);
				this.pstmt.setString(1, id);
				this.rs = this.pstmt.executeQuery();

				if (this.rs.next()) {
					String driverCode = this.rs.getString(1);
					String clientId = this.rs.getString(2);
					String password = this.rs.getString(3);
					String name = this.rs.getString(4);
					String phone = this.rs.getString(5);
					String address = this.rs.getString(6);
					Timestamp regDate = this.rs.getTimestamp(7, Calendar.getInstance());
					
//					String time = this.rs.getString(7);
//					System.out.println("time : " + time);
//					
//					SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd hh:mm:ss");
//					Date date = null;
//					Timestamp regDate = null;
//					try {
//						date = sdf.parse(time);
//						regDate = new Timestamp(date.getTime());
//					} catch (ParseException e) {
//						e.printStackTrace();
//					}
//					
//					System.out.println("regDate : " + regDate);

					client = new Client(driverCode, clientId, password, name, phone, address, regDate);
				}

			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt, rs);
			}
		}
		return client;
	}

	// U
	public void updatePasswordById(String id, String password) {
		this.conn = DBManager.getConnection();

		if (this.conn != null) {
			String sql = "UPDATE client SET password = ? WHERE client_id = ?";

			try {
				this.pstmt = this.conn.prepareStatement(sql);
				this.pstmt.setString(1, password);
				this.pstmt.setString(2, id);

//				this.pstmt.execute();
				int resultInt = this.pstmt.executeUpdate();
				System.out.println("resultInt ==> " + resultInt);
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt);
			}
		}
	}
	
	// 유저 업데이트
	public void updateClient(ClientRequestDto clientDto) {
		this.conn = DBManager.getConnection();

		if (this.conn != null) {
			String sql = "UPDATE client SET driver_code = ?, client_id = ?,";
			sql += "password = ?, client_name = ?, phone = ?,address = ?";
			sql += "WHERE driver_code = ?";

			try {
				this.pstmt = this.conn.prepareStatement(sql);
				this.pstmt.setString(1, clientDto.getDriverCode());
				this.pstmt.setString(2, clientDto.getId());
				this.pstmt.setString(3, clientDto.getPassword());
				this.pstmt.setString(4, clientDto.getName());
				this.pstmt.setString(5, clientDto.getPhone());
				this.pstmt.setString(6, clientDto.getAddress());
				this.pstmt.setString(7, clientDto.getDriverCode());

				this.pstmt.execute();

			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt);
			}
		}
	}

	// D
	public void deleteClientById(String id) {
		this.conn = DBManager.getConnection();

		if (this.conn != null) {
			String sql = "DELETE FROM client WHERE client_id = ?";

			try {
				this.pstmt = this.conn.prepareStatement(sql);
				this.pstmt.setString(1, id);

				this.pstmt.execute();

			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt);
			}

		}
	}

}
