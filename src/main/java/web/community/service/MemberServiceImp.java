package web.community.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import web.community.dao.MemberDao;

@Service
public class MemberServiceImp implements MemberService{

	@Autowired
	MemberDao memberdao;
	
	@Override
	public void ServiceJoin(String id, String pw, String nickname, String name, int birth, String email, String gender,
			String phone) {
		// TODO Auto-generated method stub
		
		if(id!=null&&pw!=null&&nickname!=null&&name!=null&&birth!=1&&email!=null&&gender!=null&&phone!=null) {
			memberdao.InsertMember(id, pw, nickname, name, birth, email, gender, phone);	
		}
	}

	@Override
	public void ServiceIdCheck(String id) {
		String check = memberdao.SelectId(id);
		System.out.println(check);
	}
	
	@Override
	public void ServiceLogin() {
		// TODO Auto-generated method stub
		
	}

		
}
