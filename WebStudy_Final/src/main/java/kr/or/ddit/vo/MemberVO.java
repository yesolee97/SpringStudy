package kr.or.ddit.vo;

import java.io.Serializable;
import java.time.LocalDateTime;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode(of = "memId")
public class MemberVO implements Serializable{
	@NotBlank
	private String memId;
	@NotBlank
	private String memPassword;
	@NotBlank
	private String memName;
	@ToString.Exclude
	private transient String memRegno1;
	@ToString.Exclude
	private transient String memRegno2;
	private LocalDateTime memBir;
	private String memZip;
	private String memAdd1;
	private String memAdd2;
	private String memHometel;
	private String memComtel;
	private String memHp;
	private String memMail;
	private String memJob;
	private String memHobby;
	private String memMemorial;
	private String memMemorialday;
	private Integer memMileage;
	// ture: T|t|y|Y|1
	// false : F|f|N|n|0 null
	private boolean memDelete;
	
	private String memRole;
}
