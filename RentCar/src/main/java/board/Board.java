package board;

import java.sql.Timestamp;

public class Board {
	
	private int boardNum;
	private int type;
	private String boardWriter, title, content;
	private Timestamp createdDate, modifiedDate;
	
	public Board(int boardNum, int type, String boardWriter, String title, String content, Timestamp createdDate, Timestamp modifiedDate) {
		this.boardNum = boardNum;
		this.type = type;
		this.boardWriter = boardWriter;
		this.title = title;
		this.content = content;
		this.createdDate = createdDate;
		this.modifiedDate = modifiedDate;
	}
	
	// 사용하면 anotation 지우기
	public Board(int type, String boardWriter, String title, String content) {
		this.type = type;
		this.boardWriter = boardWriter;
		this.title = title;
		this.content = content;
	}
	
	// getBoardAll()
	public Board(int boardNum, String boardWriter, String title, String content, Timestamp createdDate) {
		this.boardNum = boardNum;
		this.boardWriter = boardWriter;
		this.title = title;
		this.content = content;
		this.createdDate = createdDate;
	}
	
	public Board(BoardRequestDto boardDto) {
		
	}

	public int getBoardNum() {
		return boardNum;
	}

	public int getType() {
		return type;
	}

	public String getBoardWriter() {
		return boardWriter;
	}

	public String getTitle() {
		return title;
	}

	public String getContent() {
		return content;
	}

	public Timestamp getCreateDate() {
		return createdDate;
	}

	public Timestamp getModifiedDate() {
		return modifiedDate;
	}
	
}
