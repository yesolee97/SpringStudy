package kr.or.ddit.common;

import lombok.Getter;

@Getter
public class PaginationInfo {
	private int totalRecordCount;		// totalRecord, 데이터베이스 조회
	
	private int currentPageNo;			// currentPage, 요청 파라미터
	// ↑↑↑ 얘네는 외부에서 받아와야해서 setter가 있어야 함	
	
	private int pageSize = 5;				// blockSize,	
	private int recordCountPerPage = 10;		// screenSize
	
	private int totalPageCount;			// totalPage, (totalRecord / screenSize로 계산)
	
	private int firstRecordIndex;		// startRow, (blockSize / currentPage 로 계산)
	private int lastRecordIndex;		// endRow,   (blockSize / currentPage 로 계산)
	
	private int firstPageNoOnPageList;	// startPage, (screenSize / currentPage 로 계산)
	private int lastPageNoOnPageList;	// endPage,   (screenSize / currentPage 로 계산)
	
	public void setTotalRecordCount(int totalRecordCount) {
		this.totalRecordCount = totalRecordCount;
	}
	public void setCurrentPageNo(int currentPageNo) {
		this.currentPageNo = currentPageNo;
	}
	
	
	public int getTotalPageCount() {
		totalPageCount = ((totalRecordCount-1)/recordCountPerPage) + 1;
		return totalPageCount;
	}
	public int getFirstRecordindex() {
		firstRecordIndex = (currentPageNo - 1) * recordCountPerPage + 1;
		return firstRecordIndex;
	}
	
	public int getLastRecordindex() {
		lastRecordIndex = currentPageNo * recordCountPerPage;
		return lastRecordIndex;
	}
	// 페이지 리스트의 첫 페이지 번호	
	public int getFirstPageNoOnPageList() {
		firstPageNoOnPageList = ((currentPageNo-1)/pageSize)*pageSize + 1;
		return firstPageNoOnPageList;
	}
	
	// 페이지 리스트의 마지막 페이지 번호	
	public int getLastPageNoOnPageList() {
		lastPageNoOnPageList = firstPageNoOnPageList+pageSize-1;
		// 라스트 페이지 보정작업
		if(lastPageNoOnPageList>getTotalPageCount()){
			lastPageNoOnPageList=totalPageCount;
		}
		return lastPageNoOnPageList;
	}
}
