package kr.or.ddit.common.renderer;

import kr.or.ddit.common.PaginationInfo;

public interface PaginationRenderer {
	// PaginationInfo + String을 받아 페이지를 만들어주는 메서드!
	/**
	 * starPage 부터 endPage 까지의 동적 페이지 링크를 생성하는 메서드
	 * @param paging
	 * @param fnName
	 * @return
	 */
	
	String renderPagination(PaginationInfo paging, String fnName);
}
