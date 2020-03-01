package com.clf.meetingfilm.backenduser.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.clf.meetingfilm.backenduser.model.MoocBackendUserT;

public interface MoocBackendUserTDao extends BaseMapper<MoocBackendUserT> {
    int deleteByPrimaryKey(Integer uuid);

    int insertSelective(MoocBackendUserT record);

    MoocBackendUserT selectByPrimaryKey(Integer uuid);

    int updateByPrimaryKeySelective(MoocBackendUserT record);

    int updateByPrimaryKey(MoocBackendUserT record);
}