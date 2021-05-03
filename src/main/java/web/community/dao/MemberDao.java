package web.community.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

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

	@Update("update member set nickname=#{nickname}, email=#{email}, phone=#{phone} where id=#{id}")
	void UpdateMember(String id, String nickname, String email, String phone);

	@Update("update member set nickname=#{nickname}, email=#{email}, phone=#{phone}, img=#{img_name} where id=#{id}")
	void UpdateMember2(String id, String nickname, String email, String phone, String img_name);

	@Update("update member set pw=#{pw} where id=#{id}")
	void UpdatePw(String id, String pw);
	
}
