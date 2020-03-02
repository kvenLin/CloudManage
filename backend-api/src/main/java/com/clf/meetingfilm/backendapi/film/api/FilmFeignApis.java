package com.clf.meetingfilm.backendapi.film.api;

import com.clf.meetingfilm.backendapi.film.vo.DescribeFilmRespVO;
import com.clf.meetingfilm.backendutils.common.vo.BaseResponseVO;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public interface FilmFeignApis {
    /**
     * 对外暴露的接口服务
     * @param filmId
     * @return
     */
    @RequestMapping(value = "/films/{filmId}", method = RequestMethod.GET)
    BaseResponseVO<DescribeFilmRespVO> describeFilmById(@PathVariable("filmId") String filmId);
}
