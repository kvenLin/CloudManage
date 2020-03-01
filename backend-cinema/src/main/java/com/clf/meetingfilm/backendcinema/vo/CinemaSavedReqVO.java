package com.clf.meetingfilm.backendcinema.vo;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @Author: clf
 * @Date: 2020-03-01
 * @Description: TODO
 */
@Data
public class CinemaSavedReqVO {
    private String brandId;
    private String areaId;
    private String hallTypeIds;
    private String cinemaName;
    private String cinemaAddress;
    private String cinemaTele;
    private String cinemaImgAddress;
    private String cinemaPrice;
}
