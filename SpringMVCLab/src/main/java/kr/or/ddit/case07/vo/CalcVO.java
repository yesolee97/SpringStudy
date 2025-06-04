package kr.or.ddit.case07.vo;

import jakarta.validation.constraints.Min;
import lombok.Data;

@Data
public class CalcVO {
	@Min(1)
	private int op1;
	@Min(1)
	private int op2;
	
	private int result;
}
