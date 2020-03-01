package com.clf.meetingfilm.backendhall.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.clf.meetingfilm.backendhall.service.HallService;
import com.clf.meetingfilm.backendhall.vo.HallSavedReqVO;
import com.clf.meetingfilm.backendhall.vo.HallsReqVO;
import com.clf.meetingfilm.backendhall.vo.HallsRespVO;
import com.clf.meetingfilm.backendutils.common.vo.BaseResponseVO;
import com.clf.meetingfilm.backendutils.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @Author: clf
 * @Date: 2020-03-01
 * @Description: TODO
 */
@RestController
@RequestMapping("halls")
public class HallController {

    @Autowired
    private HallService hallService;

    @PostMapping("hall:add")
    public BaseResponseVO saveHall(@RequestBody @Valid HallSavedReqVO hallSavedReqVO) {
        hallService.saveHall(hallSavedReqVO);
        return BaseResponseVO.success();
    }

    @GetMapping("")
    public BaseResponseVO describeHalls(@RequestBody @Valid HallsReqVO hallsReqVO) {
        IPage<HallsRespVO> page = hallService.describeHalls(hallsReqVO);
        return BaseResponseVO.success(PageUtil.getPageResult(page, "halls"));
    }
}
