package web.community.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import web.community.model.Member;

public interface MemberService {

	void ServiceJoin(String id, String pw, String nickname, String name, int birth, String email, String gender,
			String phone);

	boolean ServiceIdCheck(String id);
	
	String ServiceLogin(String id, String pw, HttpSession session);

	void ServiceChangeMember(String id, String nickname, String email, String phone, String img);


}
