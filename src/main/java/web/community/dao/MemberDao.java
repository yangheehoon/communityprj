package web.community.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import web.community.model.Member;

@Mapper
public interface MemberDao {

	@Insert("insert into member values(null,#{id},#{pw},#{nickname},#{name},#{birth},#{email},#{gender},#{phone},now(),'none.png')")
	void InsertMember(String id, String pw, String nickname, 
			String name, int birth, String email, String gender, 
			String phone);

	@Select("select id from member where id=#{id}")
	String SelectId(String id);

	@Select("select id,pw from member where id=#{id} and pw=#{pw}")
	String SelectLoginCheck(String id, String pw);

	@Select("select * from member where id=#{id} and pw=#{pw}")
	Member SelectMember(String id, String pw);
	
}
