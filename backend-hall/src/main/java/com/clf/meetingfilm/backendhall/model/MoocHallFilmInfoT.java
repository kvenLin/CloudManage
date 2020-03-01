package com.clf.meetingfilm.backendhall.model;

import java.io.Serializable;
import lombok.Data;

/**
 * mooc_hall_film_info_t
 * @author 
 */
@Data
public class MoocHallFilmInfoT implements Serializable {
    /**
     * 主键编号
     */
    private Integer uuid;

    /**
     * 电影编号
     */
    private Integer filmId;

    /**
     * 电影名称
     */
    private String filmName;

    /**
     * 电影时长
     */
    private String filmLength;

    /**
     * 电影类型
     */
    private String filmCats;

    /**
     * 电影语言
     */
    private String filmLanguage;

    /**
     * 演员列表
     */
    private String actors;

    /**
     * 图片地址
     */
    private String imgAddress;

    private static final long serialVersionUID = 1L;
}