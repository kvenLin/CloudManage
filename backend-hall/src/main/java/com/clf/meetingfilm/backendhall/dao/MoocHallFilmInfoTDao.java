package com.clf.meetingfilm.backendhall.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.clf.meetingfilm.backendhall.model.MoocHallFilmInfoT;

public interface MoocHallFilmInfoTDao extends BaseMapper<MoocHallFilmInfoT> {
    int deleteByPrimaryKey(Integer uuid);

    int insert(MoocHallFilmInfoT record);

    int insertSelective(MoocHallFilmInfoT record);

    MoocHallFilmInfoT selectByPrimaryKey(Integer uuid);

    int updateByPrimaryKeySelective(MoocHallFilmInfoT record);

    int updateByPrimaryKey(MoocHallFilmInfoT record);
}