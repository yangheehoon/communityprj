package web.community.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface MemberDao {

	@Insert("insert into member values(null,#{id},#{pw},#{nickname},#{name},#{birth},#{email},#{gender},#{phone},now(),'none.png')")
	void InsertMember(String id, String pw, String nickname, 
			String name, int birth, String email, String gender, 
			String phone);

	@Select("select * from member where id=#{id}")
	String SelectId(String id);
	
}
