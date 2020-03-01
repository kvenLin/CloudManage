package com.clf.meetingfilm.backendfilm.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.clf.meetingfilm.backendfilm.model.MoocFilmActorT;

public interface MoocFilmActorTDao extends BaseMapper<MoocFilmActorT> {
    int deleteByPrimaryKey(Integer uuid);

    int insert(MoocFilmActorT record);

    int insertSelective(MoocFilmActorT record);

    MoocFilmActorT selectByPrimaryKey(Integer uuid);

    int updateByPrimaryKeySelective(MoocFilmActorT record);

    int updateByPrimaryKey(MoocFilmActorT record);
}