package web.community.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import web.community.service.MemberService;

@Controller
@RequestMapping("/member/")
public class MemberController {
	
	@Autowired
	MemberService memberservice;
	
	@RequestMapping("join")
	public String join(@RequestParam(value="id",required=false) String id,
			@RequestParam(value="pw",required=false) String pw,
			@RequestParam(value="nickname",required=false) String nickname,
			@RequestParam(value="name",required=false) String name,
			@RequestParam(value="birth",defaultValue="1") int birth,
			@RequestParam(value="email",required=false) String email,
			@RequestParam(value="gender",required=false) String gender,
			@RequestParam(value="phone",required=false) String phone ) {
		
			memberservice.ServiceJoin(id, pw, nickname, name, birth, email, gender, phone);
	
		return "member/join";
	}
	
	@ResponseBody
	@RequestMapping("idcheck")
	public String idcheck(@RequestParam(value="id") String id) {
		System.out.println(id);
		boolean result = memberservice.ServiceIdCheck(id);		
		
		if(result==true) {
			return "possibleID"; 
		}else {
			return "impossibleID";
		}

	}
	
	@RequestMapping("login")
	public String login() {
		
			memberservice.ServiceLogin();
		
		return "member/login";
	}
	
	
}
