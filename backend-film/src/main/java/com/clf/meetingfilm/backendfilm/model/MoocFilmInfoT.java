package com.clf.meetingfilm.backendfilm.model;

import java.io.Serializable;
import lombok.Data;

/**
 * mooc_film_info_t
 * @author 
 */
@Data
public class MoocFilmInfoT implements Serializable {
    /**
     * 主键编号
     */
    private Integer uuid;

    /**
     * 影片编号
     */
    private String filmId;

    /**
     * 影片英文名称
     */
    private String filmEnName;

    /**
     * 影片评分
     */
    private String filmScore;

    /**
     * 评分人数,以万为单位
     */
    private Integer filmScoreNum;

    /**
     * 播放时长，以分钟为单位，不足取整
     */
    private Integer filmLength;

    /**
     * 影片介绍
     */
    private String biography;

    /**
     * 导演编号
     */
    private Integer directorId;

    /**
     * 影片图片集地址,多个图片以逗号分隔
     */
    private String filmImgs;

    private static final long serialVersionUID = 1L;
}