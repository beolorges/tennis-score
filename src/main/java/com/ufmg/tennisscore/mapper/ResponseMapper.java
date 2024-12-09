package com.ufmg.tennisscore.mapper;

import com.ufmg.tennisscore.model.entity.SportEvent;
import com.ufmg.tennisscore.model.response.SportEventResponse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface ResponseMapper  {
    SportEventResponse toResponse(SportEvent sportEvent);

    List<SportEventResponse> toResponse(List<SportEvent> sportEvents);
}
