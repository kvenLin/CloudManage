package com.clf.meetingfilm.backendcinema.model;

import java.io.Serializable;
import lombok.Data;

/**
 * mooc_cinema_t
 * @author 
 */
@Data
public class MoocCinemaT implements Serializable {
    /**
     * 主键编号
     */
    private Integer uuid;

    /**
     * 影院名称
     */
    private String cinemaName;

    /**
     * 影院电话
     */
    private String cinemaPhone;

    /**
     * 品牌编号
     */
    private Integer brandId;

    /**
     * 地域编号
     */
    private Integer areaId;

    /**
     * 包含的影厅类型,以#作为分割
     */
    private String hallIds;

    /**
     * 影院图片地址
     */
    private String imgAddress;

    /**
     * 影院地址
     */
    private String cinemaAddress;

    /**
     * 最低票价
     */
    private Integer minimumPrice;

    private static final long serialVersionUID = 1L;
}