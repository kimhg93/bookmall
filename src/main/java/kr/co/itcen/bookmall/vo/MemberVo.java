package kr.co.itcen.bookmall.vo;

public class MemberVo {
	private Long no;
	private String name;
	private String number;
	private String email;
	private String passwd;
	public Long getNo() {
		return no;
	}
	public void setNo(Long no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	@Override
	public String toString() {
		return "회원 [회원번호:" + no + ", 이름:" + name + ", 전화번호:" + number + ", 이메일:" + email + ", 비밀번호:"
				+ passwd + "]";
	}	
	
}
