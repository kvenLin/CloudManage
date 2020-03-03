package com.clf.meetingfilm.backendhall.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.clf.meetingfilm.backendapi.film.vo.DescribeFilmRespVO;
import com.clf.meetingfilm.backendhall.apis.FilmFeignApi;
import com.clf.meetingfilm.backendhall.dao.MoocFieldTDao;
import com.clf.meetingfilm.backendhall.dao.MoocHallFilmInfoTDao;
import com.clf.meetingfilm.backendhall.model.MoocFieldT;
import com.clf.meetingfilm.backendhall.model.MoocHallFilmInfoT;
import com.clf.meetingfilm.backendhall.service.HallService;
import com.clf.meetingfilm.backendhall.vo.HallSavedReqVO;
import com.clf.meetingfilm.backendhall.vo.HallsReqVO;
import com.clf.meetingfilm.backendhall.vo.HallsRespVO;
import com.clf.meetingfilm.backendutils.common.vo.BaseResponseVO;
import com.clf.meetingfilm.backendutils.enums.ErrorEnum;
import com.clf.meetingfilm.backendutils.exception.CommonException;
import com.clf.meetingfilm.backendutils.util.ToolUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: clf
 * @Date: 2020-03-01
 * @Description: TODO
 */
@Service
public class HallServiceImpl implements HallService {
    @Autowired
    private MoocFieldTDao fieldDao;
    @Autowired
    private MoocHallFilmInfoTDao hallFilmInfoDao;
    @Autowired
    private FilmFeignApi filmFeignApi;
    @Override
    public IPage<HallsRespVO> describeHalls(HallsReqVO hallsReqVO) {
        Page<HallsReqVO> page = new Page<>(hallsReqVO.getNowPage(),hallsReqVO.getPageSize());
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("cinema_id", hallsReqVO.getCinemaId());
        IPage<HallsRespVO> result = fieldDao.describeHalls(page, queryWrapper);
        return result;
    }

    @Override
    public void saveHall(HallSavedReqVO hallSavedReqVO) {
        MoocFieldT field = new MoocFieldT();
        field.setCinemaId(ToolUtils.str2Int(hallSavedReqVO.getCinemaId()));
        field.setFilmId(ToolUtils.str2Int(hallSavedReqVO.getFilmId()));
        field.setBeginTime(hallSavedReqVO.getBeginTime());
        field.setEndTime(hallSavedReqVO.getEndTime());
        field.setHallId(ToolUtils.str2Int(hallSavedReqVO.getHallTypeId()));
        field.setHallName(hallSavedReqVO.getHallName());
        field.setPrice(ToolUtils.str2Int(hallSavedReqVO.getFilmPrice()));
        try {
            fieldDao.insert(field);
        } catch (Exception e) {
            throw new CommonException(ErrorEnum.SAVE_HALL_ERROR);
        }
        //使用Feign根据filmId获取film信息,添加hallFilmInfo
        BaseResponseVO<DescribeFilmRespVO> baseResponseVO = filmFeignApi.describeFilmById(hallSavedReqVO.getFilmId());
        DescribeFilmRespVO filmResult = baseResponseVO.getData();
        if(filmResult == null || StringUtils.isEmpty(filmResult.getFilmId())) {
            throw new CommonException(ErrorEnum.FILM_NOT_FOUND);
        }
        MoocHallFilmInfoT hallFilmInfo = new MoocHallFilmInfoT();
        hallFilmInfo.setFilmId(ToolUtils.str2Int(filmResult.getFilmId()));
        hallFilmInfo.setFilmName(filmResult.getFilmName());
        hallFilmInfo.setFilmLength(filmResult.getFilmLength());
        hallFilmInfo.setFilmCats(filmResult.getFilmCats());
        hallFilmInfo.setActors(filmResult.getActors());
        hallFilmInfo.setImgAddress(filmResult.getImgAddress());

        try {
            hallFilmInfoDao.insert(hallFilmInfo);
        } catch (Exception e) {
            throw new CommonException(ErrorEnum.SAVE_HALL_FILM_INFO_ERROR);
        }
    }
}
