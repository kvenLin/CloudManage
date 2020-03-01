package com.clf.meetingfilm.backenduser.vo;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @Author: clf
 * @Date: 2020-02-29
 * @Description: TODO
 */
@Data
public class LoginReqVO {
    @NotNull(message = "用户名不能为空")
    private String username;
    @NotNull(message = "密码不能为空")
    private String password;
}
