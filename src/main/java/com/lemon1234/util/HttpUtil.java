package com.lemon1234.util;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;

import com.alibaba.fastjson.JSON;

/**
 * Http Util 类
 * 
 * @date 2021年1月19日
 * @author lemon1234.zhihua
 */
public class HttpUtil {

	/**
	 * 向页面输出
	 * @param response
	 * @param message
	 */
	public static void print(HttpServletResponse response, Object message){
        try {
            response.setStatus(HttpStatus.OK.value());
            response.setContentType("application/json;charset=UTF-8");
            response.setHeader("Cache-Control", "no-cache, must-revalidate");
            PrintWriter writer = response.getWriter();
            writer.write(JSON.toJSONString(message));
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
