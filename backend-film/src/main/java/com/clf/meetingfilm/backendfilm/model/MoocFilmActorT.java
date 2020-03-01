package com.clf.meetingfilm.backendfilm.model;

import java.io.Serializable;
import lombok.Data;

/**
 * mooc_film_actor_t
 * @author 
 */
@Data
public class MoocFilmActorT implements Serializable {
    /**
     * 主键编号
     */
    private Integer uuid;

    /**
     * 影片编号,对应mooc_film_t
     */
    private Integer filmId;

    /**
     * 演员编号,对应mooc_actor_t
     */
    private Integer actorId;

    /**
     * 角色名称
     */
    private String roleName;

    private static final long serialVersionUID = 1L;
}