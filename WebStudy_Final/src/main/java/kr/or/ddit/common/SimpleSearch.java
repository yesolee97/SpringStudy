package kr.or.ddit.common;

import lombok.Data;

/**
 * 검색조건과 검색 키워드로만 구성된 단순 키워드 검색에 사용
 */
@Data
public class SimpleSearch{
	private String searchType;
	private String searchWord;
}
