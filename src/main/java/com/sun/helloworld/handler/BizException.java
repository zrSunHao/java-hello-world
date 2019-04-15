package com.sun.helloworld.handler;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author sun 异常处理
 */
@ControllerAdvice
public class BizException {

	/**
	 * 拦截Exception类的异常
	 */
	@ExceptionHandler(Exception.class)
	@ResponseBody
	public Map<String, Object> exceptionHandler(Exception ex) {

		Map<String, Object> result = new HashMap<String, Object>();
//        result.put("respCode", "Exception");
//        result.put("respMsg", ex.getMessage());
		
		result.put("success", false);
		result.put("errorMessage", ex.getMessage());
		result.put("hasErrors", true);

		// 正常开发中，可创建一个统一响应实体，如CommonResp
		return result;
	}

	/**
	 * 拦截RuntimeException类的异常
	 */
	@ExceptionHandler({ RuntimeException.class })
	@ResponseBody
	public Map<String, Object> proccessException(RuntimeException ex) {

		Map<String, Object> result = new HashMap<String, Object>();
//		result.put("respCode", "RuntimeException");
//		result.put("respMsg", ex.getMessage());
		
		result.put("success", false);
		result.put("errorMessage", ex.getMessage());
		result.put("hasErrors", true);

		// 正常开发中，可创建一个统一响应实体，如CommonResp
		return result;
	}

}
