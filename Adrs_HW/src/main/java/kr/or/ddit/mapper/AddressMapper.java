package kr.or.ddit.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ddit.vo.AddressBookVO;

@Mapper
public interface AddressMapper {
	public List<AddressBookVO> selectAddrList();
	public AddressBookVO selectAddr(Integer adrsNo );
	public int insertAddr(AddressBookVO addr);
	public int updateAddr(AddressBookVO addr);
	public int deleteAddr(AddressBookVO addr);
}
