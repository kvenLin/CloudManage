package com.clf.meetingfilm.backendhall.dao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.clf.meetingfilm.backendhall.model.MoocFieldT;
import com.clf.meetingfilm.backendhall.vo.HallsReqVO;
import com.clf.meetingfilm.backendhall.vo.HallsRespVO;
import org.apache.ibatis.annotations.Param;

public interface MoocFieldTDao extends BaseMapper<MoocFieldT> {
    int deleteByPrimaryKey(Integer uuid);

    int insert(MoocFieldT record);

    int insertSelective(MoocFieldT record);

    MoocFieldT selectByPrimaryKey(Integer uuid);

    int updateByPrimaryKeySelective(MoocFieldT record);

    int updateByPrimaryKey(MoocFieldT record);

    IPage<HallsRespVO> describeHalls(Page<HallsReqVO> page, @Param("ew")QueryWrapper queryWrapper);

}