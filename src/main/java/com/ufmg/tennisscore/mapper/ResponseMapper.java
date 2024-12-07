package com.ufmg.tennisscore.mapper;

import com.ufmg.tennisscore.model.entity.SportEvent;
import com.ufmg.tennisscore.model.response.SportEventResponse;
import org.mapstruct.Mapper;

@Mapper
public interface ResponseMapper  {
    SportEventResponse toResponse(SportEvent sportEvent);
}
