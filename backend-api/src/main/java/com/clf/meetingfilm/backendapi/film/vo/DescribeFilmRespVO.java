package com.clf.meetingfilm.backendapi.film.vo;

import lombok.Data;

/**
 * @Author: clf
 * @Date: 2020-03-01
 * @Description: 查询影片信息接口返回对象
 */
@Data
public class DescribeFilmRespVO {
    private String filmId;
    private String filmName;
    private String filmLength;
    private String filmCats;
    private String actors;
    private String imgAddress;
    private String subAddress;
}
