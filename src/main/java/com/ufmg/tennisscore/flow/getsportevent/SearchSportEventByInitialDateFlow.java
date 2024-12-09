package com.ufmg.tennisscore.flow.getsportevent;

import com.ufmg.tennisscore.mapper.ResponseMapper;
import com.ufmg.tennisscore.model.entity.SportEvent;
import com.ufmg.tennisscore.model.request.SearchSportEventRequest;
import com.ufmg.tennisscore.model.response.SportEventResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SearchSportEventByInitialDateFlow {
    private final SearchSportEventByInitialDateFlowItem searchSportEventByInitialDateFlowItem;
    private final ResponseMapper responseMapper;

    public List<SportEventResponse> search(LocalDateTime initialDate) {
        List<SportEvent> sportEvents = searchSportEventByInitialDateFlowItem.search(initialDate);
        return responseMapper.toResponse(sportEvents);
    }
}
