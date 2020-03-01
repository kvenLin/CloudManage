package com.clf.meetingfilm.backendfilm.vo;

import lombok.Data;

/**
 * @Author: clf
 * @Date: 2020-03-01
 * @Description: 查询影片列表接口返回对象
 */
@Data
public class DescribeFilmsRespVO {
    private String filmStatus;
    private String filmName;
    private String filmEnName;
    private String filmScore;
    private String preSaleNum;
    private String boxOffice;
    private String filmTime;
    private String filmLength;
    private String mainImg;
}
