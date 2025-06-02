package kr.or.ddit.buyer.service;

import java.util.List;
import java.util.Optional;

import kr.or.ddit.vo.BuyerVO;

/**
 * 제조사 관리용 business logic layer
 */
public interface BuyerService {	
	public List<BuyerVO> readBuyerList();
	public Optional<BuyerVO> readBuyer(String buyerId);
	public void createBuyer(BuyerVO buyer);	// 등록성공(아무일도 발생x), 등록실패 - 익셉션발생
	public void modifyBuyer(BuyerVO buyer);
	
	
}
