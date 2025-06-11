package kr.or.ddit.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ddit.vo.BuyerVO;

/**
 * 제조사 관리용 Persistence layer
 */
@Mapper
public interface BuyerMapper {
	public List<BuyerVO> selectBuyerList();
	public BuyerVO selectBuyer(String buyerId);
	public int insertBuyer(BuyerVO buyer);	// db 이용해야되니까 돌아오는 row 카운트 받을 수 있어야 함
	public int updateBuyer(BuyerVO buyer);
}
