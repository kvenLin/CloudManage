package com.clf.meetingfilm.backendhall.vo;

import lombok.Data;

/**
 * @Author: clf
 * @Date: 2020-03-01
 * @Description: TODO
 */
@Data
public class HallsRespVO {
    private String cinemaName;
    private String hallName;
    private String filmName;
    private String hallTypeName;
    private String beginTime;
    private String endTime;
    private String filmPrice;
}
