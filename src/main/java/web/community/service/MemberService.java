package web.community.service;

public interface MemberService {

	void ServiceJoin(String id, String pw, String nickname, String name, int birth, String email, String gender,
			String phone);

	boolean ServiceIdCheck(String id);
	
	void ServiceLogin();


}
