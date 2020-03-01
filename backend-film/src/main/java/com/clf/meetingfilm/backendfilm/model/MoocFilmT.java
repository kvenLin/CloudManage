package com.clf.meetingfilm.backendfilm.model;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * mooc_film_t
 * @author 
 */
@Data
public class MoocFilmT implements Serializable {
    /**
     * 主键编号
     */
    private Integer uuid;

    /**
     * 影片名称
     */
    private String filmName;

    /**
     * 片源类型: 0-2D,1-3D,2-3DIMAX,4-无
     */
    private Integer filmType;

    /**
     * 影片主图地址
     */
    private String imgAddress;

    /**
     * 影片评分
     */
    private String filmScore;

    /**
     * 影片预售数量
     */
    private Integer filmPresalenum;

    /**
     * 影片票房：每日更新，以万为单位
     */
    private Integer filmBoxOffice;

    /**
     * 影片片源，参照片源字典表
     */
    private Integer filmSource;

    /**
     * 影片分类，参照分类表,多个分类以#分割
     */
    private String filmCats;

    /**
     * 影片区域，参照区域表
     */
    private Integer filmArea;

    /**
     * 影片上映年代，参照年代表
     */
    private Integer filmDate;

    /**
     * 影片上映时间
     */
    private Date filmTime;

    /**
     * 影片状态,1-正在热映，2-即将上映，3-经典影片
     */
    private Integer filmStatus;

    private static final long serialVersionUID = 1L;
}