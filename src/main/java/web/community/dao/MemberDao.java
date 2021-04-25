package web.community.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberDao {

	@Insert("insert into member values(#{id},#{pw},#{nickname},#{name},#{birth},#{email},#{gender},#{phone},sysdate,'none.png')")
	void InsertMember(String id, String pw, String nickname, 
			String name, int birth, String email, String gender, 
			String phone);
}
