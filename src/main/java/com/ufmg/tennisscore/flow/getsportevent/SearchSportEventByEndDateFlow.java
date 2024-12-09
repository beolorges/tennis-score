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
public class SearchSportEventByEndDateFlow {
    private final SearchSportEventByEndDateFlowItem searchSportEventByEndDateFlowItem;
    private final ResponseMapper responseMapper;

    public List<SportEventResponse> search(LocalDateTime endDate) {
        List<SportEvent> sportEvents = searchSportEventByEndDateFlowItem.search(endDate);
        return responseMapper.toResponse(sportEvents);
    }
}
