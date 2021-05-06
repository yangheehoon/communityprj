package web.community.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import web.community.model.Board;
import web.community.service.BoardService;

@Controller
@RequestMapping("/board/")
public class BoardController {
	
	@Autowired
	BoardService boardservice;

	@RequestMapping("list")
	public String BoardList(Model model) {
		
		List<Board> list = boardservice.ServiceList();
		
		model.addAttribute("list", list);
		
		return "board/list";	
	}
}
