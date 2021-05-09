package web.community.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import web.community.dao.BoardDao;
import web.community.model.Board;

@Service
public class BoardServiceImp implements BoardService{

	@Autowired
	BoardDao boarddao;
	
	@Override
	public List<Board> ServiceList() {
		return boarddao.SelectList();
	
		// TODO Auto-generated method stub
		
	}

	@Override
	public Board ServiceDetail(int num) {
		// TODO Auto-generated method stub
		return boarddao.SelectDetail(num);
	}

	@Override
	public void ServiceAddBoard(String title, String content, String writer_id, String filesname) {
		// TODO Auto-generated method stub
		
	}

}
