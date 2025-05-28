package web.mvc.service;

import web.mvc.exception.BasicException;

public interface UserService {
	/**
	 * 나이 체크
	 */
	void ageCheck(int age) throws BasicException;

	/**
	 * 중복체크
	 */
	void idCheck(String id) throws BasicException;
}
