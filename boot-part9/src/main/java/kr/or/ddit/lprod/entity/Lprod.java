package kr.or.ddit.lprod.entity;

import java.util.List;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import kr.or.ddit.beyer.entity.Buyer;
import lombok.Data;

@Data
@Entity
public class Lprod {
	private Integer lprodId;
	@Id
	private String lprodGu;
	private String lprodName;
	
	// has many
	@OneToMany(mappedBy = "lprod")
	private List<Buyer> buyerList;
}
