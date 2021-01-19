package com.lemon1234.sys.exception;

/**
 * 全局系统异常
 */
public class AppException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public AppException(String message) {
		super(message);
	}
	
	public AppException(Throwable cause) {
        super(cause);
    }
	
	public static void main(String[] args) {
		throw new AppException(new RuntimeException("12341234"));
	}
}
