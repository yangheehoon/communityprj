package web.community.service;

import java.util.List;

import web.community.model.Board;

public interface BoardService {
	
	List<Board> ServiceList();

	Board ServiceDetail(int num);

	void ServiceAddBoard(String title, String content, String writer_id, String filesname);
}
