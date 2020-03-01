package com.clf.meetingfilm.backendfilm.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.clf.meetingfilm.backendfilm.service.FilmService;
import com.clf.meetingfilm.backendfilm.vo.DescribeActorsRespVO;
import com.clf.meetingfilm.backendfilm.vo.DescribeFilmRespVO;
import com.clf.meetingfilm.backendfilm.vo.DescribeFilmsRespVO;
import com.clf.meetingfilm.backendfilm.vo.FilmSaveReqVO;
import com.clf.meetingfilm.backendutils.common.vo.BasePageVO;
import com.clf.meetingfilm.backendutils.common.vo.BaseResponseVO;
import com.clf.meetingfilm.backendutils.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @Author: clf
 * @Date: 2020-03-01
 * @Description: 影片模块表现层
 */
@RestController
@RequestMapping("films")
public class FilmController {

    @Autowired
    private FilmService filmService;

    @GetMapping("actors")
    public BaseResponseVO describeActors(@RequestBody @Valid BasePageVO basePageVO) {
        IPage<DescribeActorsRespVO> actors = filmService.describeActors(basePageVO.getNowPage(), basePageVO.getPageSize());
        return BaseResponseVO.success(PageUtil.getPageResult(actors, "actors"));
    }

    @GetMapping("")
    public BaseResponseVO describeFilms(@RequestBody @Valid BasePageVO basePageVO) {
        IPage<DescribeFilmsRespVO> films = filmService.describeFilms(basePageVO.getNowPage(), basePageVO.getPageSize());
        return BaseResponseVO.success(PageUtil.getPageResult(films, "films"));
    }

    @GetMapping("{filmId}")
    public BaseResponseVO describeFilmById(@PathVariable("filmId") String filmId) {
        DescribeFilmRespVO film = filmService.describeFilmById(filmId);
        return BaseResponseVO.success(film);
    }

    @PostMapping("film:add")
    public BaseResponseVO describeFilmById(@RequestBody @Valid FilmSaveReqVO filmSaveReqVO) {
        filmService.saveFilm(filmSaveReqVO);
        return BaseResponseVO.success();
    }
}
