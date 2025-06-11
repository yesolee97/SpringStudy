package kr.or.ddit.lprod.service;

import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import kr.or.ddit.mapper.LprodMapper;
import kr.or.ddit.vo.LprodVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class LprodServiceImpl implements LprodService {
	private final LprodMapper mapper;
	
	
	@Override
	public List<LprodVO> readLprodList() {
		// 일반 pojo 객체에서 인증객체 확보하는 법
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		log.info("authentication: {}", authentication);
		return mapper.selectLprodList();
	}

}
