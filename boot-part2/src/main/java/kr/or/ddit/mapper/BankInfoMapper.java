package kr.or.ddit.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import kr.or.ddit.vo.BankInfoVO;

@Mapper
public interface BankInfoMapper {
	@Select("""
			SELECT *
			FORM BANKINFO
			""")
	public List<BankInfoVO> selectbankList();
}
