package com.clf.meetingfilm.backenduser;

import com.clf.meetingfilm.backenduser.dao.MoocBackendUserTDao;
import com.clf.meetingfilm.backenduser.model.MoocBackendUserT;
import com.clf.meetingfilm.backenduser.service.UserService;
import com.clf.meetingfilm.backendutils.util.MD5Util;
import com.github.houbb.markdown.toc.core.impl.AtxMarkdownToc;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BackendUserApplicationTests {

    @Autowired
    private MoocBackendUserTDao moocBackendUserTDao;

    /**
     * 添加后台运维用户功能
     */
    @Test
    void add() {
        MoocBackendUserT user = new MoocBackendUserT();
        user.setUserName("clf");
        user.setUserPwd(MD5Util.encrypt("admin123"));
        user.setUserPhone("12345678911");
        moocBackendUserTDao.insert(user);
    }
    @Test
    public void mdTest() {
        AtxMarkdownToc.newInstance().genTocFile("../README.md");
    }

}
