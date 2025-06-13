package kr.or.ddit.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import kr.or.ddit.vo.MemberVO;

@Mapper
public interface MemberMapper {
	@Select("""
		SELECT MEM_ID, MEM_NAME, MEM_MAIL, MEM_ADD1, MEM_ROLE
		  FROM MEMBER
		 WHERE MEM_MAIL = #{mail}
	""")
	public MemberVO selectMemberByMail(@Param("mail") String mail);	// oauth로 로그인할떄 사용한 email을 넘겨줘야함
}
