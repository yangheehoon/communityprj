package web.community.service;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import web.community.dao.MemberDao;
import web.community.model.Member;

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
	public boolean ServiceIdCheck(String id) {
		String check = memberdao.SelectId(id);
		
		System.out.println(check);
		
		if(check==null) {
			return true;
		}else {
			return false;
		}
		
	}
	
	@Override
	public String ServiceLogin(String id, String pw, HttpSession session) {
		
		String check = memberdao.SelectId(id);
		String check2 = memberdao.SelectLoginCheck(id,pw);
		System.out.println(check);
		System.out.println(check2);
		
		if(check==null) {
			return "IdNone";
		}else if(check2==null) {
			return "PwNone";
		}else {
			Member member = memberdao.SelectMember(id,pw);
			session.setAttribute("member", member);
			return "Success";
		}
	}

	@Override
	public void ServiceChangeMember(String id, String pw, String nickname, String email, String phone, HttpSession session) {
		
		memberdao.UpdateMember(id, nickname, email, phone);
		Member member = memberdao.SelectMember(id, pw);
		session.setAttribute("member", member);
		
	}

	@Override
	public void ServiceChangeMember2(String id, String pw, String nickname, String email, String phone, String img_name,
			HttpSession session) {
		
		memberdao.UpdateMember2(id, nickname, email, phone, img_name);
		Member member = memberdao.SelectMember(id, pw);
		session.setAttribute("member", member);
	}


	
}
