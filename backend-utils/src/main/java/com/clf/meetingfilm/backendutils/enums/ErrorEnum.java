package com.clf.meetingfilm.backendutils.enums;

import lombok.Data;
import lombok.Getter;

/**
 * @Author: clf
 * @Date: 2020-02-29
 * @Description: 错误枚举
 */
@Getter
public enum  ErrorEnum {
    SERVER_ERROR(500,"服务器未知错误:%s" ),
    REQUEST_METHOD_ERROR(550,"不支持%s的请求方式" ),
    BIND_ERROR(511,"参数校验错误:%s"),
    USER_NOT_FUND(501, "用户不存在"),
    PASSWORD_WRONG(502, "用户密码错误");
    private Integer code;
    private String msg;

    ErrorEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
