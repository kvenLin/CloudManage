package com.clf.meetingfilm.backendhall.apis;

import com.clf.meetingfilm.backendapi.film.api.FilmFeignApis;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("film-service")
public interface FilmFeignApi extends FilmFeignApis {
}
