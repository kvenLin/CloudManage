package com.clf.meetingfilm.backendhall.vo;

import com.clf.meetingfilm.backendutils.common.vo.BasePageVO;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @Author: clf
 * @Date: 2020-03-01
 * @Description: TODO
 */
@Data
public class HallsReqVO extends BasePageVO {
    @NotNull(message = "影院id不能为空")
    private String cinemaId;
}
