package com.clf.meetingfilm.backendfilm.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.clf.meetingfilm.backendfilm.model.MoocFilmInfoT;

public interface MoocFilmInfoTDao extends BaseMapper<MoocFilmInfoT> {
    int deleteByPrimaryKey(Integer uuid);

    int insert(MoocFilmInfoT record);

    int insertSelective(MoocFilmInfoT record);

    MoocFilmInfoT selectByPrimaryKey(Integer uuid);

    int updateByPrimaryKeySelective(MoocFilmInfoT record);

    int updateByPrimaryKey(MoocFilmInfoT record);
}