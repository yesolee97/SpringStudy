package kr.or.ddit.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(of="adrsNo")
@NoArgsConstructor
public class AddressBookVO {
	private Integer adrsNo;
	private String memId;
	private String adrsName;
	private String adrsTel;
	private String adrsAdd;
}
