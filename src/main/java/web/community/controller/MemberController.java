package web.community.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import web.community.model.Member;
import web.community.service.MemberService;

@Controller
@RequestMapping("/member/")
public class MemberController {
	
	@Autowired
	private ServletContext ctx;
	
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
	
			if(id!=null&&pw!=null&&nickname!=null&&name!=null&&birth!=1&&email!=null&&gender!=null&&phone!=null) {
				return "member/success";
			}				
			
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
		return "member/login";
	}
	
	@ResponseBody
	@RequestMapping("logincheck")
	public String LoginCheck(@RequestParam("id") String id,
			@RequestParam("pw") String pw,
			HttpSession session) {
			
			System.out.println(id);
			System.out.println(pw);
		
		return memberservice.ServiceLogin(id,pw,session);
		
	}
	
	@RequestMapping("logout")
	public String Logout(HttpSession session) {
		session.invalidate();
		
		return "redirect:/home";
	}
	
	@RequestMapping("mypage")
	public String MyPage() {
		
		return "member/mypage";
	}
	
	@RequestMapping("change_member")
	public String ChangeMember(@RequestParam(value="id",required=false)String id,
			@RequestParam(value="pw",required=false)String pw,
			@RequestParam(value="nickname",required=false)String nickname,
			@RequestParam(value="email",required=false)String email,
			@RequestParam(value="phone",required=false)String phone,
			@RequestParam(value="img",required=false)MultipartFile img,
			HttpSession session) throws IllegalStateException, IOException {
		
		System.out.println(img);
		
		if(nickname!=null&&email!=null&&phone!=null&&id!=null&&pw!=null&&img.isEmpty()) {			
			memberservice.ServiceChangeMember(id,pw,nickname,email,phone,session);
			return "redirect:/member/mypage";
			
		}else if(nickname!=null&&email!=null&&phone!=null&&id!=null&&pw!=null&&!img.isEmpty()){
			
			String filename = img.getOriginalFilename();		
			String realpath= ctx.getRealPath("/img/member");
			System.out.println(realpath);
			realpath += File.separator + filename;
			File savefile = new File(realpath);
			img.transferTo(savefile);
			String img_name= filename;
			
			memberservice.ServiceChangeMember2(id,pw,nickname,email,phone,img_name,session);
			return "redirect:/member/mypage";
		}
		
		return "member/change_member";
	}
}
