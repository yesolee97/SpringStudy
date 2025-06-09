package kr.or.ddit.prod.service;

import java.util.List;
import java.util.Optional;

import kr.or.ddit.vo.ProdVO;

/**
 * 상품 관리(CRUD) Business logic layer
 */
public interface ProdService {
	public void createProd(ProdVO prod);
	public List<ProdVO> readProdList();
	public Optional<ProdVO> readProd(String prodId);	// 이거 왜 널포인트의 안전한 코드를 짤 수 있음??
	public void modifyProd(ProdVO prod);
}
	