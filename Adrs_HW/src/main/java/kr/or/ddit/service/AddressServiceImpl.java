package kr.or.ddit.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.ddit.mapper.AddressMapper;
import kr.or.ddit.vo.AddressBookVO;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class AddressServiceImpl implements AddressService {
	private final AddressMapper mapper;

	@Override
	public List<AddressBookVO> readAddrList() {
		return mapper.selectAddrList();
	}

	@Override
	public Optional<AddressBookVO> readAddr(Integer adrsNo) {
		return Optional.ofNullable(mapper.selectAddr(adrsNo));
	}

	@Override
	public void createAddr(AddressBookVO addr) {
		mapper.insertAddr(addr);
	}

	@Override
	public void editAddr(AddressBookVO addr) {
		mapper.updateAddr(addr);
	}

	@Override
	public void deleteAddr(AddressBookVO addr) {
		mapper.deleteAddr(addr);

	}

}
