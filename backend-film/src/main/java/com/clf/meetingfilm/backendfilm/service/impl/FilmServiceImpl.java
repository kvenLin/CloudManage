package com.clf.meetingfilm.backendfilm.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.clf.meetingfilm.backendfilm.dao.MoocActorTDao;
import com.clf.meetingfilm.backendfilm.dao.MoocFilmActorTDao;
import com.clf.meetingfilm.backendfilm.dao.MoocFilmInfoTDao;
import com.clf.meetingfilm.backendfilm.dao.MoocFilmTDao;
import com.clf.meetingfilm.backendfilm.model.MoocFilmActorT;
import com.clf.meetingfilm.backendfilm.model.MoocFilmInfoT;
import com.clf.meetingfilm.backendfilm.model.MoocFilmT;
import com.clf.meetingfilm.backendfilm.service.FilmService;
import com.clf.meetingfilm.backendfilm.vo.DescribeActorsRespVO;
import com.clf.meetingfilm.backendfilm.vo.DescribeFilmRespVO;
import com.clf.meetingfilm.backendfilm.vo.DescribeFilmsRespVO;
import com.clf.meetingfilm.backendfilm.vo.FilmSaveReqVO;
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
public class FilmServiceImpl implements FilmService {

    @Autowired
    private MoocActorTDao actorTDao;
    @Autowired
    private MoocFilmActorTDao filmActorTDao;
    @Autowired
    private MoocFilmTDao filmTDao;
    @Autowired
    private MoocFilmInfoTDao filmInfoTDao;

    @Override
    public IPage<DescribeActorsRespVO> describeActors(int nowPage, int pageSize) {
        return actorTDao.describeActors(new Page<>(nowPage, pageSize));
    }

    @Override
    public IPage<DescribeFilmsRespVO> describeFilms(int nowPage, int pageSize) {
        return filmTDao.describeFilms(new Page<>(nowPage, pageSize));
    }

    @Override
    public DescribeFilmRespVO describeFilmById(String filmId) {
        return filmTDao.describeFilmById(filmId);
    }

    @Transactional(rollbackFor = Exception.class)//所有异常都回滚
    @Override
    public void saveFilm(FilmSaveReqVO filmSaveReqVO) {
        try {
            //保存电影主表
            MoocFilmT film = new MoocFilmT();
            film.setFilmName(filmSaveReqVO.getFilmName());
            film.setFilmType(ToolUtils.str2Int(filmSaveReqVO.getFilmTypeId()));
            film.setImgAddress(filmSaveReqVO.getMainImgAddress());
            film.setFilmScore(filmSaveReqVO.getFilmScore());
            film.setFilmPresalenum(ToolUtils.str2Int(filmSaveReqVO.getPreSaleNum()));
            film.setFilmBoxOffice(ToolUtils.str2Int(filmSaveReqVO.getBoxOffice()));
            film.setFilmSource(ToolUtils.str2Int(filmSaveReqVO.getFilmSourceId()));
            film.setFilmCats(filmSaveReqVO.getFilmCatIds());
            film.setFilmArea(film.getFilmArea());
            film.setFilmDate(film.getFilmDate());
            film.setFilmTime(ToolUtils.str2LocalDateTime(filmSaveReqVO.getFilmTime()));
            film.setFilmStatus(ToolUtils.str2Int(filmSaveReqVO.getFilmStatus()));
            filmTDao.insert(film);

            //保存电影子表
            MoocFilmInfoT filmInfo = new MoocFilmInfoT();
            filmInfo.setFilmId(film.getUuid() + "");
            filmInfo.setFilmEnName(filmSaveReqVO.getFilmName());
            filmInfo.setFilmScore(filmSaveReqVO.getFilmScore());
            filmInfo.setFilmScoreNum(ToolUtils.str2Int(filmSaveReqVO.getFilmScorers()));
            filmInfo.setFilmLength(ToolUtils.str2Int(filmSaveReqVO.getFilmLength()));
            filmInfo.setBiography(filmSaveReqVO.getBiography());
            filmInfo.setDirectorId(ToolUtils.str2Int(filmSaveReqVO.getDirectorId()));
            filmInfo.setFilmImgs(filmSaveReqVO.getFilmImgs());
            filmInfoTDao.insert(filmInfo);

            //保存演员映射
            String[] actIds = filmSaveReqVO.getActIds().split("#");
            String[] roles = filmSaveReqVO.getRoleNames().split("#");
            if(actIds.length != roles.length) {
                throw new CommonException(ErrorEnum.ROLE_MATCH_ACT_ERROR);
            }
            for (int i = 0; i < actIds.length; i++) {
                MoocFilmActorT filmActor = new MoocFilmActorT();
                filmActor.setFilmId(film.getUuid());
                filmActor.setActorId(ToolUtils.str2Int(actIds[i]));
                filmActor.setRoleName(roles[i]);
                filmActorTDao.insert(filmActor);
            }
        } catch (Exception e) {
            throw new CommonException(ErrorEnum.SAVE_FILM_FAILED);
        }
    }
}
