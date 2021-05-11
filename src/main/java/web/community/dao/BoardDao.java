package web.community.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import web.community.model.Board;

@Mapper
public interface BoardDao {

	@Select("select * from board order by regdate desc")
	List<Board> SelectList();

	@Select("select * from board where num=#{num}")
	Board SelectDetail(int num);

	@Insert("insert into board values(null,#{title},#{content},#{writer_id},#{filesname},0,now(),0)")
	void InsertBoard(String title, String content, String writer_id, String filesname);
}
