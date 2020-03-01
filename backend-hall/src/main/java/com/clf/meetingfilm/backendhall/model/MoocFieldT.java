package com.clf.meetingfilm.backendhall.model;

import java.io.Serializable;
import lombok.Data;

/**
 * mooc_field_t
 * @author 
 */
@Data
public class MoocFieldT implements Serializable {
    /**
     * 主键编号
     */
    private Integer uuid;

    /**
     * 影院编号
     */
    private Integer cinemaId;

    /**
     * 电影编号
     */
    private Integer filmId;

    /**
     * 开始时间
     */
    private String beginTime;

    /**
     * 结束时间
     */
    private String endTime;

    /**
     * 放映厅类型编号
     */
    private Integer hallId;

    /**
     * 放映厅名称
     */
    private String hallName;

    /**
     * 票价
     */
    private Integer price;

    private static final long serialVersionUID = 1L;
}