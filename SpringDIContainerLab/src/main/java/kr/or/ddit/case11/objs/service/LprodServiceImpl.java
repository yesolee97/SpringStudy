package kr.or.ddit.case11.objs.service;

import java.util.List;
import java.util.Optional;

import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.inject.Inject;
import kr.or.ddit.case11.objs.mapper.LprodMapper;
import kr.or.ddit.vo.LprodVO;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor

public class LprodServiceImpl {
	private final LprodMapper mapper;
	
	public List<LprodVO> readLprodList(){
		return mapper.selectLprodList();
	};
	
	public Optional<LprodVO> readLprod(String LprodGu){
		return Optional.ofNullable(mapper.selectLprod(LprodGu));		
	};
}
