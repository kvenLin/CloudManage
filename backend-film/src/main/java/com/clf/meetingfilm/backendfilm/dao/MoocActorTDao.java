package com.clf.meetingfilm.backendfilm.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.clf.meetingfilm.backendfilm.model.MoocActorT;
import com.clf.meetingfilm.backendfilm.vo.DescribeActorsRespVO;

public interface MoocActorTDao extends BaseMapper<MoocActorT> {

    IPage<DescribeActorsRespVO> describeActors(Page<DescribeActorsRespVO> page);

    int deleteByPrimaryKey(Integer uuid);

    int insert(MoocActorT record);

    int insertSelective(MoocActorT record);

    MoocActorT selectByPrimaryKey(Integer uuid);

    int updateByPrimaryKeySelective(MoocActorT record);

    int updateByPrimaryKey(MoocActorT record);
}