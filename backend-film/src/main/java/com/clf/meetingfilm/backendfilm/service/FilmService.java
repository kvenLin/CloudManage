package com.clf.meetingfilm.backendfilm.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.clf.meetingfilm.backendfilm.vo.DescribeActorsRespVO;
import com.clf.meetingfilm.backendfilm.vo.DescribeFilmRespVO;
import com.clf.meetingfilm.backendfilm.vo.DescribeFilmsRespVO;
import com.clf.meetingfilm.backendfilm.vo.FilmSaveReqVO;

public interface FilmService {
    /**
     * 查询演员列表
     * @param nowPage
     * @param pageSize
     * @return
     */
    IPage<DescribeActorsRespVO> describeActors(int nowPage, int pageSize);

    /**
     * 查询影片列表
     * @param nowPage
     * @param pageSize
     * @return
     */
    IPage<DescribeFilmsRespVO> describeFilms(int nowPage, int pageSize);

    /**
     * 根据根据电影Id查询电影
     * @param filmId
     * @return
     */
    DescribeFilmRespVO describeFilmById(String filmId);

    /**
     * 保存影片信息
     * @param filmSaveReqVO
     */
    void saveFilm(FilmSaveReqVO filmSaveReqVO);
}
