package com.clf.meetingfilm.backenduser.controller;

import com.clf.meetingfilm.backenduser.service.UserService;
import com.clf.meetingfilm.backenduser.vo.LoginReqVO;
import com.clf.meetingfilm.backendutils.common.vo.BaseResponseVO;
import com.clf.meetingfilm.backendutils.util.JwtTokenUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: clf
 * @Date: 2020-02-29
 * @Description: TODO
 */
@Slf4j
@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public BaseResponseVO login(@RequestBody @Valid LoginReqVO reqVO) {
        String userId = userService.checkUserLogin(reqVO.getUsername(), reqVO.getPassword());
        JwtTokenUtil jwtTokenUtil = new JwtTokenUtil();
        String randomKey = jwtTokenUtil.getRandomKey();
        String token = jwtTokenUtil.generateToken(userId, randomKey);
        Map<String, String> map = new HashMap<>();
        map.put("randomKey", randomKey);
        map.put("token", token);
        return BaseResponseVO.success(map);
    }

}
