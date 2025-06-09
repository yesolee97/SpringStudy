package kr.or.ddit.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(of = "bankNo")
public class BankInfoVO {
	private String bankNo;
	private String bankName;
	private String bankUserName;
	private String bankDate;
}
