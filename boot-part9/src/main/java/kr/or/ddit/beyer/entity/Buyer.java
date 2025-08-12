package kr.or.ddit.beyer.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import kr.or.ddit.lprod.entity.Lprod;
import lombok.Data;

@Data
@Entity
public class Buyer {
	@Id
	private String buyerId;
	private String buyerName;
	
//	private String lprodGu;
	@ManyToOne
	@JoinColumn(name = "lprod_gu")
	private Lprod lprod;
	
	private String buyerBank;
	private String buyerBankno;
	private String buyerBankname;
	private String buyerZip;
	private String buyerAdd1;
	private String buyerAdd2;
	private String buyerComtel;
	private String buyerFax;
	private String buyerMail;
	private String buyerCharger;
	private String buyerTelext;
	@Column(columnDefinition = "BLOB")
	private byte[] buyerImg;
}
