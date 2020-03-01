package com.clf.meetingfilm.backendcinema.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.clf.meetingfilm.backendcinema.model.MoocCinemaT;
import com.clf.meetingfilm.backendcinema.vo.DescribeCinemasRespVO;

public interface MoocCinemaTDao extends BaseMapper<MoocCinemaT> {
    int deleteByPrimaryKey(Integer uuid);

    int insert(MoocCinemaT record);

    int insertSelective(MoocCinemaT record);

    MoocCinemaT selectByPrimaryKey(Integer uuid);

    int updateByPrimaryKeySelective(MoocCinemaT record);

    int updateByPrimaryKey(MoocCinemaT record);

    IPage<DescribeCinemasRespVO> describeCinemas(Page<DescribeCinemasRespVO> page);
}