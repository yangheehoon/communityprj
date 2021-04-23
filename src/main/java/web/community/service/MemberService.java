package web.community.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import web.community.dao.MemberDao;

@Service
public class MemberService {
	
	@Autowired
	MemberDao memberdao;
	
	public void ServiceJoin(String id, String pw, String nickname, 
			String name, int birth, String email, String gender, 
			String phone) {
		
		if(id!=null) {
			memberdao.InsertMember(id, pw, nickname, name, birth, email, gender, phone);	
		}
	}	
}
