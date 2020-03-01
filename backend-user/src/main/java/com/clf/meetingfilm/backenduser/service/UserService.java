package com.clf.meetingfilm.backenduser.service;

import com.clf.meetingfilm.backendutils.exception.CommonException;

public interface UserService {
    /**
     * 校验用户登录
     * @param username
     * @param password
     * @throws CommonException
     * @return
     */
    String checkUserLogin(String username, String password) throws CommonException;
}
