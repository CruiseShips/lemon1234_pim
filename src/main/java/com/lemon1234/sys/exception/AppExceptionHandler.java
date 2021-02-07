package com.lemon1234.sys.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lemon1234.entity.dict.Constants;
import com.lemon1234.sys.result.Result;

/**
 * 异常处理栈
 */
@ControllerAdvice
public class AppExceptionHandler {

	@ExceptionHandler(value = AppException.class)  
    @ResponseBody
	public Result appExceptionResult(HttpServletRequest req, AppException e) {
		return Result.error(Constants.HTTP_201, e.getMessage());
	}
}
