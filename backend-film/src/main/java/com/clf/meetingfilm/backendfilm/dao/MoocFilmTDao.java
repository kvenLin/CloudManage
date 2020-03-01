package com.clf.meetingfilm.backendfilm.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.clf.meetingfilm.backendfilm.model.MoocFilmT;
import com.clf.meetingfilm.backendfilm.vo.DescribeFilmRespVO;
import com.clf.meetingfilm.backendfilm.vo.DescribeFilmsRespVO;
import org.apache.ibatis.annotations.Param;

public interface MoocFilmTDao extends BaseMapper<MoocFilmT> {
    int deleteByPrimaryKey(Integer uuid);

    int insert(MoocFilmT record);

    int insertSelective(MoocFilmT record);

    MoocFilmT selectByPrimaryKey(Integer uuid);

    int updateByPrimaryKeySelective(MoocFilmT record);

    int updateByPrimaryKey(MoocFilmT record);

    IPage<DescribeFilmsRespVO> describeFilms(Page<DescribeFilmsRespVO> objectPage);

    DescribeFilmRespVO describeFilmById(@Param("filmId") String filmId);
}