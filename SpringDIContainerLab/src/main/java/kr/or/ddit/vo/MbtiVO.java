package kr.or.ddit.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
/**
 * Domain Layer: 테이블의 스키마(엔터티 구조)를 반영함. 
 * JavaBean 규약에 따라 개발되어야 함 -> lombok 활용 중
 */
@Data
@EqualsAndHashCode(of = "mtType")
@NoArgsConstructor	// 기본생성자
//@AllArgsConstructor	// 모든 프로퍼티를 받는 생성자
public class MbtiVO {
	
	// 기본 / 모든 프로퍼티를 가진 생성자 외에 추가 생성자 필요할 경우 오버라이딩
	public MbtiVO(String mtType) {
		super();
		this.mtType = mtType;
	}
	
	private Integer mtSort;
	private String mtType;
	private String mtTitle;
	private String mtContent;
	
	
	private MbtiVO(Integer mtSort, String mtType, String mtTitle, String mtContent) {
		super();
		this.mtSort = mtSort;
		this.mtType = mtType;
		this.mtTitle = mtTitle;
		this.mtContent = mtContent;
	}

	// private 생성자를 사용할 수 있는 builder 메소드 생성
	public static MbtiVOBuilder builder() {
		return new MbtiVOBuilder();
	}
	
	// 얘 왜 private 했다가 public으로 해줌?
	public static class MbtiVOBuilder{
		private Integer mtSort;
		private String mtType;
		private String mtTitle;
		private String mtContent;
		
		public MbtiVOBuilder mtSort(Integer mtSort){
			this.mtSort = mtSort;
			return this;	// mtSort 반환하는 게 아니라 builder 반환하는 거??
		}
		
		public MbtiVOBuilder mtType(String mtType){
			this.mtType = mtType;
			return this;
		}
		
		public MbtiVOBuilder mtTitle(String mtTitle){
			this.mtTitle = mtTitle;
			return this;
		}
		
		public MbtiVOBuilder mtContent(String mtContent){
			this.mtContent = mtContent;
			return this;
		}

		
		public MbtiVO build() {
			return new MbtiVO(mtSort, mtType, mtTitle, mtContent);
		}
	}
	
}
