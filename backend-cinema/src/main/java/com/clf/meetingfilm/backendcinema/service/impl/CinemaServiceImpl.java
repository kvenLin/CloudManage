package com.clf.meetingfilm.backendcinema.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.clf.meetingfilm.backendcinema.dao.MoocCinemaTDao;
import com.clf.meetingfilm.backendcinema.model.MoocCinemaT;
import com.clf.meetingfilm.backendcinema.service.CinemaService;
import com.clf.meetingfilm.backendcinema.vo.CinemaSavedReqVO;
import com.clf.meetingfilm.backendcinema.vo.DescribeCinemasRespVO;
import com.clf.meetingfilm.backendutils.enums.ErrorEnum;
import com.clf.meetingfilm.backendutils.exception.CommonException;
import com.clf.meetingfilm.backendutils.util.ToolUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author: clf
 * @Date: 2020-03-01
 * @Description: TODO
 */
@Service
public class CinemaServiceImpl implements CinemaService {
    @Autowired
    private MoocCinemaTDao cinemaDao;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void saveCinema(CinemaSavedReqVO cinemaSavedReqVO) {
        MoocCinemaT cinema = new MoocCinemaT();
        cinema.setCinemaName(cinemaSavedReqVO.getCinemaName());
        cinema.setCinemaPhone(cinemaSavedReqVO.getCinemaTele());
        cinema.setBrandId(ToolUtils.str2Int(cinemaSavedReqVO.getBrandId()));
        cinema.setAreaId(ToolUtils.str2Int(cinemaSavedReqVO.getAreaId()));
        cinema.setHallIds(cinemaSavedReqVO.getHallTypeIds());
        cinema.setImgAddress(cinemaSavedReqVO.getCinemaImgAddress());
        cinema.setCinemaAddress(cinemaSavedReqVO.getCinemaAddress());
        cinema.setMinimumPrice(ToolUtils.str2Int(cinemaSavedReqVO.getCinemaPrice()));
        try {
            cinemaDao.insert(cinema);
        } catch (Exception e) {
            throw new CommonException(ErrorEnum.SAVE_CINEMA_ERROR);
        }
    }

    @Override
    public IPage<DescribeCinemasRespVO> describeCinemas(Integer nowPage, Integer pageSize) {
        return cinemaDao.describeCinemas(new Page<>(nowPage, pageSize));
    }
}
