/*
 * Lenovo Group
 * Copyright (c) 2015-2016 All Rights Reserved.
 * Project Name: skynet web
 * Create Time: 16-11-02 下午5:30
 */

/**
 * Lenovo Group
 * Copyright (c) 2014-2015 All Rights Reserved.
 */
package com.lenovo.onsite.common;

/**
 * 通用异常类
 *
 * @author suo
 */
public class OnsiteException extends RuntimeException {

    /**  */
    private static final long serialVersionUID = 1L;
    /**
     * 错误码对应ErrorCode
     */
    private int code = -1;
    /**
     * 错误信息
     */
    private String message;

    public OnsiteException(ErrorCode ec) {
        super();
        this.code = ec.getCode();
        this.message = ec.getTitle();
    }

    public OnsiteException(String message) {
        super(message);
        this.code = -1;
        this.message = message;
    }

    public OnsiteException(Throwable exp) {
        super(exp);
        this.code = -1;
        this.message = exp.getMessage();
    }

    public OnsiteException(ErrorCode ec, String message) {
        super(message);
        this.code = ec.getCode();
        this.message = message;
    }

    public OnsiteException(ErrorCode ec, Throwable exp) {
        super(exp);
        this.code = ec.getCode();
        this.message = exp.getMessage();
    }

    public int getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }
}
