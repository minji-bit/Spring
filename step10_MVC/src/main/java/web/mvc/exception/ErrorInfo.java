package web.mvc.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * 예외코드와 예외메시지를 상수객체로 관리
 * enum은 서로 관련된 값들을 상수로 관리하는 객체
 */
@RequiredArgsConstructor
@Getter
public enum ErrorInfo {
	/**
	 * 나이가 18보다 작을 때 발생
	 */
	INVALID_AGE("미성년자는 안됩니다.",600),
	/**
	 * ID가 중복일 때
	 */
	DUPLICATE_ID("ID가 중복입니다.",601); //생성자의 매개변수 순서는 변수 선언 순서와 동일
	
	private final String msg; //메시지
	private final int status; //상태코드
	
	/*private ErrorInfo(String msg) {
		this.msg=msg;
	}*/
	
	/*public String getMsg() {
		return msg;
	}*/
	
}
//////////////////////////////

/*class Test{
	public void aa() {
		String msg = ErrorInfo.INVALID_AGE.getMsg();
	}
}*/