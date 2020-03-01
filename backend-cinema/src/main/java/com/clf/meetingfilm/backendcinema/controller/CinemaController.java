package com.clf.meetingfilm.backendcinema.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.clf.meetingfilm.backendcinema.service.CinemaService;
import com.clf.meetingfilm.backendcinema.vo.CinemaSavedReqVO;
import com.clf.meetingfilm.backendcinema.vo.DescribeCinemasRespVO;
import com.clf.meetingfilm.backendutils.common.vo.BasePageVO;
import com.clf.meetingfilm.backendutils.common.vo.BaseResponseVO;
import com.clf.meetingfilm.backendutils.enums.ErrorEnum;
import com.clf.meetingfilm.backendutils.exception.CommonException;
import com.clf.meetingfilm.backendutils.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @Author: clf
 * @Date: 2020-03-01
 * @Description: 影院模块表现层
 */
@RestController
@RequestMapping("cinemas")
public class CinemaController {

    @Autowired
    private CinemaService cinemaService;

    @PostMapping("cinema:add")
    public BaseResponseVO saveCinema(@RequestBody @Valid CinemaSavedReqVO cinemaSavedReqVO) {
        cinemaService.saveCinema(cinemaSavedReqVO);
        return BaseResponseVO.success();
    }


    @GetMapping("")
    public BaseResponseVO describeCinemas(@RequestBody @Valid BasePageVO basePageVO) {
        if(basePageVO.getNowPage()>10000){
            throw new CommonException(ErrorEnum.PAGE_TOO_BIG);
        }
        IPage<DescribeCinemasRespVO> cinemas = cinemaService.describeCinemas(basePageVO.getNowPage(), basePageVO.getPageSize());
        return BaseResponseVO.success(PageUtil.getPageResult(cinemas, "cinemas"));
    }
}
