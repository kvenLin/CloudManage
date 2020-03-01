package com.clf.meetingfilm.backendhall.vo;

import com.clf.meetingfilm.backendutils.common.vo.BasePageVO;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author : clf
 * @description :
 **/
@Data
public class HallSavedReqVO extends BasePageVO {
    @NotNull(message = "影院id不能为空")
    private String cinemaId;
    @NotNull(message = "电影id不能为空")
    private String filmId;
    @NotNull(message = "影厅类型不能为空")
    private String hallTypeId;
    @NotNull(message = "开始时间不能为空")
    private String beginTime;
    @NotNull(message = "结束时间不能为空")
    private String endTime;
    @NotNull(message = "电影价格不能为空")
    private String filmPrice;
    @NotNull(message = "影厅名称不能为空")
    private String hallName;
}
