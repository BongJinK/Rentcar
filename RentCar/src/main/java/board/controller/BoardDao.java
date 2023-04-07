package board.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;

import board.Board;
import board.BoardRequestDto;
import client.Client;
import util.DBManager;

public class BoardDao {

	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	private BoardDao() {
	}

	private static BoardDao instance = new BoardDao();

	public static BoardDao getInstance() {
		return instance;
	}

	// C
	public void writeBoard(BoardRequestDto BoardDto) {
		this.conn = DBManager.getConnection();

		if (this.conn != null) {
			String sql = "INSERT INTO board (type, board_writer, title, ";
			sql += "content) VALUES(?, ?, ?, ?)";

			try {
				this.pstmt = this.conn.prepareStatement(sql);
				this.pstmt.setInt(1, BoardDto.getType());
				this.pstmt.setString(2, BoardDto.getBoardWriter());
				this.pstmt.setString(3, BoardDto.getTitle());
				this.pstmt.setString(4, BoardDto.getContent());

				this.pstmt.execute();

			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt);
			}
		}
	}

	// R
	// 게시글 클릭
	public Board getBoardByBoardNum(int boardNum) {
		Board board = null;
		this.conn = DBManager.getConnection();

		if (this.conn != null) {
			String sql = "SELECT board_writer, title, content, created_date";
			sql += "FROM board WHERE boardNum = ?";

			try {
				this.pstmt = this.conn.prepareStatement(sql);
				this.pstmt.setInt(1, boardNum);
				this.rs = this.pstmt.executeQuery();

				if (this.rs.next()) {
					String boardWriter = this.rs.getString(1);
					String title = this.rs.getString(2);
					String content = this.rs.getString(3);
					Timestamp createdDate = this.rs.getTimestamp(4, Calendar.getInstance());

					board = new Board(boardNum, boardWriter, title, content, createdDate);
				}

			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt, rs);
			}
		}
		return board;
	}

	// 전체 검색 [공지사항, 이용후기]
	public ArrayList<Board> getBoardAllByType(int type) {
		ArrayList<Board> list = new ArrayList<>();
		this.conn = DBManager.getConnection();

		if (this.conn != null) {
			String sql = "SELECT board_number, board_writer, title,";
			sql += "content, created_date FROM board";
			if (type == 0)
				sql += " WHERE type = 0";
			else
				sql += " WHERE type = 1";

			try {
				this.pstmt = this.conn.prepareStatement(sql);
				this.rs = this.pstmt.executeQuery();

				while (this.rs.next()) {
					int boardNum = this.rs.getInt(1);
					String boardWriter = this.rs.getString(2);
					String title = this.rs.getString(3);
					String content = this.rs.getString(4);
					Timestamp createdDate = this.rs.getTimestamp(5, Calendar.getInstance());

					Board board = new Board(boardNum, boardWriter, title, content, createdDate);
					list.add(board);
				}

			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt, rs);
			}
		}
		return list;
	}

	// 작성자 검색
	public ArrayList<Board> getBoardAllByWriter(String writer) {
		ArrayList<Board> list = new ArrayList<>();
		this.conn = DBManager.getConnection();

		if (this.conn != null) {
			String sql = "SELECT board_number, board_writer, title, ";
			sql += "content, created_date FROM board WHERE board_writer = ?";

			try {
				this.pstmt = this.conn.prepareStatement(sql);
				this.pstmt.setString(1, writer);

				this.rs = this.pstmt.executeQuery();

				while (this.rs.next()) {
					int boardNum = this.rs.getInt(1);
					String boardWriter = this.rs.getString(2);
					String title = this.rs.getString(3);
					String content = this.rs.getString(4);
					Timestamp createdDate = this.rs.getTimestamp(5, Calendar.getInstance());

					Board board = new Board(boardNum, boardWriter, title, content, createdDate);
					list.add(board);
				}

			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt, rs);
			}
		}
		return list;
	}

	// 제목+내용 검색
	public ArrayList<Board> getBoardAllByKeyword(String keyword) {
		ArrayList<Board> list = new ArrayList<>();
		this.conn = DBManager.getConnection();

		if (this.conn != null) {
			String sql = "SELECT board_number, board_writer, title, ";
			sql += "content, created_date FROM board WHERE ";
			sql += "title LIKE ? OR content LIKE ?";

			try {
				String key = "%" + keyword + "%";
				this.pstmt = this.conn.prepareStatement(sql);
				this.pstmt.setString(1, key);
				this.pstmt.setString(2, key);

				this.rs = this.pstmt.executeQuery();

				while (this.rs.next()) {
					int boardNum = this.rs.getInt(1);
					String boardWriter = this.rs.getString(2);
					String title = this.rs.getString(3);
					String content = this.rs.getString(4);
					Timestamp createdDate = this.rs.getTimestamp(5, Calendar.getInstance());

					Board board = new Board(boardNum, boardWriter, title, content, createdDate);
					list.add(board);
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
	// 수정하기
	public void updateboard(BoardRequestDto boardDto) {
		this.conn = DBManager.getConnection();

		if (this.conn != null) {
			String sql = "UPDATE board SET title = ?, content= ?";
			sql += "WHERE board_number = ?";

			try {
				this.pstmt = this.conn.prepareStatement(sql);
				this.pstmt.setString(1, boardDto.getTitle());
				this.pstmt.setString(2, boardDto.getContent());
				this.pstmt.setInt(3, boardDto.getBoardNum());

				this.pstmt.execute();

			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt);
			}
		}
	}

	// D
	public void deleteBoardtByBoardNum(int BoardNum) {
		this.conn = DBManager.getConnection();

		if (this.conn != null) {
			String sql = "DELETE FROM board WHERE board_number = ?";

			try {
				this.pstmt = this.conn.prepareStatement(sql);
				this.pstmt.setInt(1, BoardNum);

				this.pstmt.execute();

			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt);
			}
		}
	}

}