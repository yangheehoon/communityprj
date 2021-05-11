package web.community.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

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
	
	@RequestMapping("detail")
	public String BoardDetail(Model model,
			@RequestParam("num") int num) {
		
		Board detail = boardservice.ServiceDetail(num);
		
		model.addAttribute("detail", detail);
		
		return "board/detail";
	}
	
	@RequestMapping("board_add")
	public String AddBoard(HttpSession session) {
		if(session.getAttribute("member")==null) {
			return "redirect:/member/login";
		}
		return "board/board_add";
	}
	
	@RequestMapping("board_add2")
	public String AddBoard2(@RequestParam("title") String title,
			@RequestParam("title") String content,
			@RequestParam("files") MultipartFile[] reqfiles,
			@RequestParam("writer_id") String writer_id) throws IOException {
		
		StringBuilder builder = new StringBuilder();
		
		for(MultipartFile file : reqfiles) {
			if(file.getSize()==0) {
				continue;
			}			
			String file_name = file.getOriginalFilename();
			builder.append(file_name+",");
			String realpath = new ClassPathResource("/static/img/board").getFile().getAbsolutePath();
			realpath += realpath+File.separator+file_name;
			File savefile = new File(realpath);
			file.transferTo(savefile);
		
		}
			
		if(!builder.toString().equals("")) {
			builder.delete(builder.length()-1, builder.length());
		}
			
		String filesname = builder.toString();
		
		if(title!=null && content!=null && !writer_id.equals("")) {
			boardservice.ServiceAddBoard(title,content,writer_id,filesname);			
		}
		
		return "redirect:/board/list";
	}
}
