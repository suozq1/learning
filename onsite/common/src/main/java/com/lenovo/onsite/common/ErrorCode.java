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
 * 错误码与国际化文件中对应
 *
 * @author suo
 */
public enum ErrorCode {
    UNKNOWN(-1, "Unknown"),
    SUCCESS(0, "Success"),
    //通用基础
    COMMON(1000, "Common failure"),
    PARAM_NULL(1001, "Input parameter is null"),
    PARAM_MISS(1002, "Miss required parameter"),
    PARAM_FORMAT(1003, "Input parameter format is wrong"),
    METHOD_NOTFOUND(1004, "Required method not found"),
    SERVICE_UNINIT(1005, "Service hasn't initialized"),
    UDQUERY_NOTFOUND(1006, "Named query not found"),
    MD5_ENCODE_FAIL(1007, "MD5 encode fail"),
    GE_TUI_PUSH_ALL_FAIL(1008, "GeTui push all fail"),
    GE_TUI_PUSH_SINGLE_FAIL(1009, "GeTui push single fail"),
    GE_TUI_PUSH_LIST_FAIL(1010, "GeTui push list fail"),
    INVALID_URL(1011, "Invalid url"),
    PARSE_RESPONSE_FAILURE(1012, "Parse response failure"),
    INDEX_OUT(1013, "Index out of bounds exception"),
    NUMBER_FORMAT_FAIL(1014, "Number format exception"),
    IO_EXCEPTION(1015, "IO Exception"),
    BAIDU_MAP_GEOCODING_FAIL(1016, "Baidu map geocoding fail"),
    INIT_XML_PARSER_FAIL(1017, "Init xml parser fail"),
    XML_PARSER_FAIL(1018, "Xml parser fail"),
    FTP_UPLOAD_FAIL(1019, "Ftp upload fail"),
    FTP_DOWNLOAD_FAIL(1020, "Ftp download fail"),
    GET_TOKEN_FAIL(1021,"Get token fail"),
    INVALID_CLIENT(1022,"Invalid client"),
    INVALID_GRANT_TYPE(1023,"Invalid grant type"),
    INVALID_REFRESH_TOKEN(1024,"Invalid refresh token"),
    TOKEN_EXPIRED(1025,"Token expired"), 
    ASSESS_TOKEN_NOT_FOUND(1026,"Assess token is not found,please put token in param or head(more detail consult API 3.1)"),
    RSA_DECODE_FAIL(1027,"RSA decode fail"),
    MULTI_THREAD_EXCEPTION(1028,"Multi-thread Exception"),
    
    //业务相关
    APP_KEY_ERROR(2000,"AppKey is wrong"),
    
    //数据库相关
    DATABASE_EXCEPTION(3000, "Database exception"),
    DATABASE_CONNECTION_FAILED(3001, "Database connection failed"),
    ;

    private int code;
    private String title;

    ErrorCode(int code, String title) {
        this.code = code;
        this.title = title;
    }

    public int getCode() {
        return this.code;
    }

    public String getTitle() {
        return this.title;
    }

    public static ErrorCode valueOf(int code) {
        for (ErrorCode type : ErrorCode.values()) {
            if (type.getCode() == code) {
                return type;
            }
        }
        return null;
    }
}
