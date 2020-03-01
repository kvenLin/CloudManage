package com.clf.meetingfilm.backendhall.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.clf.meetingfilm.backendhall.vo.HallSavedReqVO;
import com.clf.meetingfilm.backendhall.vo.HallsReqVO;
import com.clf.meetingfilm.backendhall.vo.HallsRespVO;

public interface HallService {
    /**
     * 获取全部播放厅
     * @param hallsReqVO
     * @return
     */
    IPage<HallsRespVO> describeHalls(HallsReqVO hallsReqVO);

    /**
     * 添加影厅
     * @param hallSavedReqVO
     */
    void saveHall(HallSavedReqVO hallSavedReqVO);
}
