
package com.lenovo.onsite.common;

import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.support.RequestContextUtils;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * 通用Response，响应前端ajax请求，该类会在设置errorCode时，自动把errorCode对应的国际化信息取出设入message
 *
 * @author suo
 */
public class Response {
  
    /**
     * 错误码
     */
    private int errorCode;
    /**
     * 返回数据
     */
    private Object data;
    /**
     * 返回信息，该值由错误码和其对应的国际化文件决定，不需要设置
     */
    private String message;
    @JsonIgnore
    private HttpServletRequest request;

    public HttpServletRequest getRequest() {
        return request;
    }

    //由于是ajax请求，前端不能获取国际化信息，所有在Response中自动获取，需要传入request
    public Response(int errorCode, HttpServletRequest request) {
        this.request = request;
        setErrorCode(errorCode);
    }

    public Response(int errorCode) {
        this.errorCode = errorCode;
    }

    public Response(ErrorCode code, HttpServletRequest request) {
		this(code.getCode(),request);
	}

	public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
        WebApplicationContext ac = RequestContextUtils.findWebApplicationContext(request);
        this.message = ac.getMessage(errorCode + "", null, RequestContextUtils.getLocale(request));
    }
    
    public void setErrorCode(ErrorCode e){
    	setErrorCode(e.getCode());
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
