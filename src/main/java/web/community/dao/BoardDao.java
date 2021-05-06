package web.community.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import web.community.model.Board;

@Mapper
public interface BoardDao {

	@Select("select * from board")
	List<Board> SelectList();
}
