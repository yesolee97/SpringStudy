package kr.or.ddit.case11.objs.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import kr.or.ddit.vo.LprodVO;

@Repository
public interface LprodMapper {
	public List<LprodVO> selectLprodList();
	
	
	
	
	
	
	@Select("""
		SELECT LPROD_NAME
		       , L.LPROD_ID
		       , L.LPROD_GU GU
		       , P.PROD_ID
		       , P.PROD_NAME
		  FROM LPROD L LEFT OUTER JOIN PROD P ON (L.LPROD_GU = P.LPROD_GU)
		 WHERE L.LPROD_GU = #{gu}
	""")	
	@ResultMap("lprodMap")
	// @Param을 사용하면 파라미터 맵을 만들어서 관리한다. > key로 gu라는 이름을 붙여주고, 그 value가 String lprodGu로 받은 값이 됌
	public LprodVO selectLprod(@Param("gu") String lprodGu);
}
