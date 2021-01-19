package com.lemon1234.sys.result;

import java.util.HashMap;

import com.lemon1234.entity.dict.Constants;

/**
 * 系统全局返回值
 */
public class Result extends HashMap<String, Object> {
	
	private static final long serialVersionUID = 1L;
	
	// 定义 key
    public static final String CODE = "code";

    public static final String MSG = "msg";
    
    public static final String DATA = "data";
	
	public Result() {}
	
	public Result(Integer code, String msg, Object data) {
		super.put(CODE, code);
        super.put(MSG, msg);
        if (data != null) {
            super.put(DATA, data);
        }
	}
	
	/**
	 * success
	 * @param code
	 * @param msg
	 * @param data
	 * @return
	 */
	public static Result success(Integer code, String msg, Object data) {
        return new Result(code, msg, data);
    }
	
	public static Result success(String msg, Object data) {
        return Result.success(Constants.REQUESTCODE.HTTP_200.getDictValue(), msg, data);
    }
	
	public static Result success(Object data) {
        return Result.success(Constants.REQUESTCODE.HTTP_200.getDictValue(), "", data);
    }
	
	public static Result success() {
        return Result.success(Constants.REQUESTCODE.HTTP_200.getDictValue(), "", null);
    }
	
	/**
	 * error
	 * @param code
	 * @param msg
	 * @param data
	 * @return
	 */
	public static Result error(Integer code, String msg, Object data) {
		return new Result(code, msg, data);
	}
	
	public static Result error(Integer code, String msg) {
        return Result.error(code, msg, null);
    }
	
	public static Result error(String msg) {
        return Result.error(Constants.REQUESTCODE.HTTP_500.getDictValue(), msg, null);
    }
	
	public static Result error() {
        return Result.error(Constants.REQUESTCODE.HTTP_500.getDictValue(), "", null);
    }
}
