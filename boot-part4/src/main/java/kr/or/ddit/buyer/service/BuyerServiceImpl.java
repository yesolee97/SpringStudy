package kr.or.ddit.buyer.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kr.or.ddit.mapper.BuyerMapper;
import kr.or.ddit.vo.BuyerVO;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BuyerServiceImpl implements BuyerService {
	
	private final BuyerMapper mapper;

	@Override
	public List<BuyerVO> readBuyerList() {
		return mapper.selectBuyerList();
	}
	@Override
	public Optional<BuyerVO> readBuyer(String buyerId) {
		return Optional.ofNullable(mapper.selectBuyer(buyerId)) ;
	}
	
	private void processImage(BuyerVO buyer) {
		try {
			// buyerImage ---> buyeerImg
			MultipartFile buyerImage = buyer.getBuyerImage();
			if(buyerImage == null || buyerImage.isEmpty()) return; // 이미지가 없을경우 return 시켜주기
			
			byte[] buyerImg =  buyerImage.getBytes();	// byte[]로 타입 변환작업
			buyer.setBuyerImg(buyerImg);
			
		} catch (IOException e) {
			throw new RuntimeException(e);	// 예외 전환
		}
	}
	
	
	@Override
	public void createBuyer(BuyerVO buyer) {
		processImage(buyer);
		mapper.insertBuyer(buyer);	
	}
	@Override
	public void modifyBuyer(BuyerVO buyer) {
		processImage(buyer);
		mapper.updateBuyer(buyer);
	}


}
