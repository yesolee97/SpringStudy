package kr.or.ddit.vo;

import java.io.Serializable;
import java.util.List;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import kr.or.ddit.validate.DeleteGroup;
import kr.or.ddit.validate.insertGroup;
import kr.or.ddit.validate.updateGroup;
import lombok.Data;
import lombok.EqualsAndHashCode;
/**
 * 하나의 제조사 정보
 * 하나의 제조사 분류 정보
 * N개의 거래품목 정보를 담기 위한 Domain
 * 
 * 제조사 관리용 Domain layer
 */
@Data
@EqualsAndHashCode(of="buyerId")
public class BuyerVO implements Serializable{
	@NotBlank(groups = {updateGroup.class, DeleteGroup.class})
	private String buyerId;
	@NotBlank
	private String buyerName;
	@NotBlank
	private String lprodGu;
	@NotBlank
	private String buyerBank;
	@NotBlank
	private String buyerBankno;
	@NotBlank
	private String buyerBankname;
	private String buyerZip;
	private String buyerAdd1;
	private String buyerAdd2;
	@NotBlank
	private String buyerComtel;
	private String buyerFax;
	@NotBlank
	@Email
	private String buyerMail;
	@NotBlank
	private String buyerCharger;
	private String buyerTelext;
	
//	@NotNull
	private transient LprodVO lprod;	// has a
	
//	@NotNull
//	@NotEmpty
	private transient List<ProdVO> prodList; // has Many
}
