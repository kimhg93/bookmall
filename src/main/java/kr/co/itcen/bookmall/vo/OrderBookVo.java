package kr.co.itcen.bookmall.vo;

public class OrderBookVo {
	private Long orderNo;
	private Long bookNo;
	private String bookName;
	private String userName;
	private int amount;
	public Long getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(Long orderNo) {
		this.orderNo = orderNo;
	}
	public Long getBookNo() {
		return bookNo;
	}
	public void setBookNo(Long bookNo) {
		this.bookNo = bookNo;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	@Override
	public String toString() {
		return "주문서적 [주문번호:" + orderNo + ", 책번호:" + bookNo + ", 책이름:" + bookName + ", 회원이름:"
				+ userName + ", 수량:" + amount + "]";
	}	
}
