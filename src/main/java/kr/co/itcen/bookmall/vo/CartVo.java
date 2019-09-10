package kr.co.itcen.bookmall.vo;

public class CartVo {
	private Long no;
	private Long book_no;
	private String userName;
	private String bookName;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}	
	public Long getNo() {
		return no;
	}
	public void setNo(Long no) {
		this.no = no;
	}
	public Long getBook_no() {
		return book_no;
	}
	public void setBook_no(Long book_no) {
		this.book_no = book_no;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	
	@Override
	public String toString() {
		return "CartVo [no=" + no + ", book_no=" + book_no + ", userName=" + userName + ", bookName=" + bookName + "]";
	}	
	
}
