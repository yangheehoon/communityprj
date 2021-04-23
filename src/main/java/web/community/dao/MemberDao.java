package web.community.dao;

import org.springframework.stereotype.Repository;

@Repository
public class MemberDao {

	public void InsertMember(String id, String pw, String nickname, 
			String name, int birth, String email, String gender, 
			String phone) {
		System.out.println(id);
		System.out.println(pw);
		System.out.println(nickname);
		System.out.println(name);
		System.out.println(birth);
		System.out.println(email);
		System.out.println(gender);
		System.out.println(phone);
	}
}
