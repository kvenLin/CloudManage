package com.clf.meetingfilm.backendfilm.model;

import java.io.Serializable;
import lombok.Data;

/**
 * mooc_actor_t
 * @author 
 */
@Data
public class MoocActorT implements Serializable {
    /**
     * 主键编号
     */
    private Integer uuid;

    /**
     * 演员名称
     */
    private String actorName;

    /**
     * 演员图片位置
     */
    private String actorImg;

    private static final long serialVersionUID = 1L;
}