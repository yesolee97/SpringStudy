package kr.or.ddit.exception;


public class ResponseStatusException extends RuntimeException{
	// 이 예외를 생성할때 상태코드를 숨겨놓고
	private final int status;
	
	public ResponseStatusException(int status, String message) {
		super(message);
		this.status = status;
	}

	// 이 메서드로 꺼내는 것도 가능한 클래스
	public int getStatus() {
		return status;
	};
}
