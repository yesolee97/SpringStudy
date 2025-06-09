package kr.or.ddit.service;

import java.util.List;
import java.util.Optional;

import kr.or.ddit.vo.AddressBookVO;

public interface AddressService {
	public List<AddressBookVO> readAddrList();
	public Optional<AddressBookVO> readAddr(Integer adrsNo);
	public void createAddr(AddressBookVO addr);
	public void editAddr(AddressBookVO addr);
	public void deleteAddr(AddressBookVO addr);	
}
