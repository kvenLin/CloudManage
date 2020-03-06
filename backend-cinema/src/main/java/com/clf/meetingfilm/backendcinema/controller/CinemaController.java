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
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
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


    /*
        fallback是业务处理的保底方案，尽可能保证这个保底方案一定能成功
     */
    public BaseResponseVO fallbackMethod(BasePageVO basePageVO) throws CommonException{
        /*
            打发票， -》 没打印纸了， 换台机器或者下次再试
            -》 触发告警 -》 告知运维人员，打印发票业务挂了
         */
        // describeCinemas -》 获取影院列表 -> 在Redis中查询影院列表[redis挂了，或者数据没了] -> 获取超时

        // fallback里捕获到超时或者数据内容与分页数不一致

        // fallback就在数据库中查询真实的影院信息

        // 返回一定是成功，或者业务处理失败
        return BaseResponseVO.success();
    }

    @HystrixCommand(fallbackMethod = "fallbackMethod",
            commandProperties = {
                    @HystrixProperty(name = "execution.isolation.strategy", value = "THREAD"),  //隔离方式
                    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value= "1000"), //超时时间
                    @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"), //超过当前最大请求数就开启熔断
                    @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "50")//错误率达到50%开启熔断
            },
            threadPoolProperties = {
                    @HystrixProperty(name = "coreSize", value = "1"),
                    @HystrixProperty(name = "maxQueueSize", value = "10"),
                    @HystrixProperty(name = "keepAliveTimeMinutes", value = "1000"),
                    @HystrixProperty(name = "queueSizeRejectionThreshold", value = "8"),
                    @HystrixProperty(name = "metrics.rollingStats.numBuckets", value = "12"),
                    @HystrixProperty(name = "metrics.rollingStats.timeInMilliseconds", value = "1500")
            },ignoreExceptions = CommonException.class)
    @RequestMapping(value = "",method = RequestMethod.GET)
    public BaseResponseVO describeCinemas(BasePageVO basePageVO) {

        IPage<DescribeCinemasRespVO> describeCinemasRespVOIPage = cinemaService.describeCinemas(basePageVO.getNowPage(), basePageVO.getPageSize());

        if(basePageVO.getNowPage()>10000){
            throw new CommonException(ErrorEnum.PAGE_TOO_BIG);
//            try {
//                Thread.sleep(2000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
        }

        // TODO 调用封装的分页返回方法

        return BaseResponseVO.success();
    }


}
