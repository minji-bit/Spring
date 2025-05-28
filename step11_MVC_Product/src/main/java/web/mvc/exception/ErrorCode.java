package web.mvc.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
@Getter
@RequiredArgsConstructor
public enum ErrorCode {
	DUPLICATE_CODE("코드가 중복되었습니다",600),
	PRICE_ERROR("가격은 1000~10000원 사이여야 합니다.",601);
	
	private final String msg;
	private final int code;
	
}
