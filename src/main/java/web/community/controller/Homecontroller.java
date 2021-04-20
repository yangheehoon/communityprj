package web.community.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Homecontroller {

	@RequestMapping("/home")
	public String Home(Model model) {
		
		model.addAttribute("sample", "re hihi");
		
		return "home";
	}
}
