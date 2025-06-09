package kr.or.ddit.lprod.service;

import java.util.List;

import kr.or.ddit.vo.LprodVO;

public interface LprodService {
	public List<LprodVO> readLprodList();
	public LprodVO readLprodOne(String lprodGu);
	public void createLprod(LprodVO lprod);
}
