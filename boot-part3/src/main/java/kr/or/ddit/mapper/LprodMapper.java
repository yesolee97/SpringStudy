package kr.or.ddit.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import kr.or.ddit.vo.LprodVO;

@Mapper
public interface LprodMapper {
	public List<LprodVO> selectLprodList();
	public LprodVO selectLprod(@Param("lprodGu") String lprodGu);
	public void insertLprod(LprodVO lprod);
}
