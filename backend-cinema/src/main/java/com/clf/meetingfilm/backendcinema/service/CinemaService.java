package com.clf.meetingfilm.backendcinema.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.clf.meetingfilm.backendcinema.vo.CinemaSavedReqVO;
import com.clf.meetingfilm.backendcinema.vo.DescribeCinemasRespVO;

public interface CinemaService {

    /**
     * 添加影院信息
     * @param cinemaSavedReqVO
     */
    void saveCinema(CinemaSavedReqVO cinemaSavedReqVO);

    /**
     * 获取影院信息
     * @param nowPage
     * @param pageSize
     * @return
     */
    IPage<DescribeCinemasRespVO> describeCinemas(Integer nowPage, Integer pageSize);
}
