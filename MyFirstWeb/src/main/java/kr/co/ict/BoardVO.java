package kr.co.ict;

import java.sql.Date;

public class BoardVO {
	// datetime에 대응하는것은
	// java.sql.Date입니다. 
	// 변수 및 set,getter, toString()까지 작성해주세요. 
	// 생성자도 만들어주세요. 
	private int board_num ;
	private String title;
	private String content;
	private String writer;
	private Date bDate; // 임포트 위에 써줌
	private Date mDate; 
	private int hit;
	
	// 생성자 소스 - generate Comstructor using Fields...누르면
		public BoardVO(int board_num, String title, String content, String writer, Date bDate, Date mDate, int hit) {
			super();
			this.board_num = board_num;
			this.title = title;
			this.content = content;
			this.writer = writer;
			this.bDate = bDate;
			this.mDate = mDate;
			this.hit = hit;
		}
		
	
	// 변수 및 set,getter
	public int getBoard_num() {
		return board_num;
	}
	public void setBoard_num(int board_num) {
		this.board_num = board_num;
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
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public java.sql.Date getbDate() {
		return bDate;
	}
	public void setbDate(java.sql.Date bDate) {
		this.bDate = bDate;
	}
	public java.sql.Date getmDate() {
		return mDate;
	}
	public void setmDate(java.sql.Date mDate) {
		this.mDate = mDate;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	
	// toString()까지
	@Override
	public String toString() {
		return "BoardVO [board_num=" + board_num + ", title=" + title + ", content=" + content + ", writer=" + writer
				+ ", bDate=" + bDate + ", mDate=" + mDate + ", hit=" + hit + "]";
	}
	
	
	
	
	
}
