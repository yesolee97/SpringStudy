package kr.or.ddit.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import kr.or.ddit.vo.LprodVO;

@Repository
//@Mapper
public interface LprodMapper {
	public List<LprodVO> selectLprodList();
	
	
	@Select("""
		SELECT LPROD_ID
		       , LPROD_GU
		       , LPROD_NAME
		  FROM LPROD
		 WHERE L.LPROD_GU = #{gu}
	""")	
	// @Param을 사용하면 파라미터 맵을 만들어서 관리한다. > key로 gu라는 이름을 붙여주고, 그 value가 String lprodGu로 받은 값이 됌
	public LprodVO selectLprod(@Param("gu") String lprodGu);
}
