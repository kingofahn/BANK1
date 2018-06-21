package domain;

public class UserBean extends MemberBean {
	private String creditRating;

	public String getCreditRating() {
		return creditRating;
	}

	public void setCreditRating(String creditRating) {
		this.creditRating = creditRating;
	}
	
	public String toString() {
		return "회원정보 [아이디:" + uid + ", "
				+ "비밀번호:" + pass 
				+ ", 이름:" + name 
				+ ", 주민번호:" + ssn 
				+ ", 주소:" + addr
				+ ", 전화번호:" + phone 
				+ ", 이메일: " + email
				+ ", 신용등급 : " + creditRating
				+ "]\n";
	}
}
