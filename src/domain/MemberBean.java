package domain;

public class MemberBean {
	protected String uid,pass,name,ssn,addr,phone,email;

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	@Override
	public String toString() {
		return "회원정보 [아이디:" + uid + ", "
				+ "비밀번호:" + pass 
				+ ", 이름:" + name 
				+ ", 주민번호:" + ssn 
				+ ", 주소:" + addr
				+ ", 전화번호:" + phone 
				+ ", 이메일: " + email
				+ "]\n";
	}
}
