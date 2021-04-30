package web.community.model;

import java.util.Date;

public class Member {
	String id;
	String pw;
	String nickname;
	String name;
	int birth;
	String email;
	String gender;
	String phone;
	Date regdate;
	String img;
	
	public Member() {
		
	}
	
	public Member(String id, String pw, String nickname, String name, int birth, String email, String gender,
			String phone, Date regdate, String img) {
		super();
		this.id = id;
		this.pw = pw;
		this.nickname = nickname;
		this.name = name;
		this.birth = birth;
		this.email = email;
		this.gender = gender;
		this.phone = phone;
		this.regdate = regdate;
		this.img = img;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getBirth() {
		return birth;
	}

	public void setBirth(int birth) {
		this.birth = birth;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	@Override
	public String toString() {
		return "Member [id=" + id + ", pw=" + pw + ", nickname=" + nickname + ", name=" + name + ", birth=" + birth
				+ ", email=" + email + ", gender=" + gender + ", phone=" + phone + ", regdate=" + regdate
				+ ", img=" + img + "]";
	}

}
