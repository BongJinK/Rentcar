package board;

import java.sql.Timestamp;

public class BoardRequestDto {
	
	private int boardNum;
	private int type;
	private String boardWriter, title, content;
	private Timestamp createdDate, modifiedDate;
	
	public BoardRequestDto(int boardNum, int type, String boardWriter, String title, String content, Timestamp createdDate, Timestamp modifiedDate) {
		this.boardNum = boardNum;
		this.type = type;
		this.boardWriter = boardWriter;
		this.title = title;
		this.content = content;
		this.createdDate = createdDate;
		this.modifiedDate = modifiedDate;
	}
	
	// 사용하면 anotation 지우기
	public BoardRequestDto(int boardNum, String boardWriter, String title, String content) {
		this.boardNum = boardNum;
		this.boardWriter = boardWriter;
		this.title = title;
		this.content = content;
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

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Timestamp getCreateDate() {
		return createdDate;
	}

	public Timestamp getModifiedDate() {
		return modifiedDate;
	}
	
}
