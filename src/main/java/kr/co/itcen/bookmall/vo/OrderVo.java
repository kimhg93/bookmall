package kr.co.itcen.bookmall.vo;

public class OrderVo {
	private Long no;
	private int payment;
	private String address;
	private String userName;
	private String userEamil;
	private Long user_no;
	public Long getNo() {
		return no;
	}
	public void setNo(Long no) {
		this.no = no;
	}
	public int getPayment() {
		return payment;
	}
	public void setPayment(int payment) {
		this.payment = payment;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Long getUser_no() {
		return user_no;
	}
	public void setUser_no(Long user_no) {
		this.user_no = user_no;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getUserEamil() {
		return userEamil;
	}
	public void setUserEamil(String userEamil) {
		this.userEamil = userEamil;
	}
	@Override
	public String toString() {
		return "주문 [주문번호:" + no + ", 결제금액:" + payment + ", 주소:" + address + ", 회원이름:" + userName
				+ ", 이메일:" + userEamil + ", 회원번호:" + user_no + "]";
	}
	
}
