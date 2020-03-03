package com.clf.meetingfilm.backenduser.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.clf.meetingfilm.backenduser.dao.MoocBackendUserTDao;
import com.clf.meetingfilm.backenduser.model.MoocBackendUserT;
import com.clf.meetingfilm.backenduser.service.UserService;
import com.clf.meetingfilm.backendutils.enums.ErrorEnum;
import com.clf.meetingfilm.backendutils.exception.CommonException;
import com.clf.meetingfilm.backendutils.util.MD5Util;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @Author: clf
 * @Date: 2020-02-29
 * @Description: TODO
 */
@Service
@Slf4j
public class UserServiceImpl implements UserService {
    @Autowired
    private MoocBackendUserTDao moocBackendUserTDao;

    @Override
    public String checkUserLogin(String username, String password) throws CommonException {
        QueryWrapper<MoocBackendUserT> queryWrapper = new QueryWrapper();
        queryWrapper.lambda().eq(MoocBackendUserT::getUserName, username);
        MoocBackendUserT user = moocBackendUserTDao.selectOne(queryWrapper);
        if(user == null) {
            throw new CommonException(ErrorEnum.USER_NOT_FOUND);
        }
        String encrypt = MD5Util.encrypt(password);
        if(!user.getUserPwd().equals(encrypt)) {
            throw new CommonException(ErrorEnum.PASSWORD_WRONG);
        }
        return user.getUuid() + "";
    }
}
