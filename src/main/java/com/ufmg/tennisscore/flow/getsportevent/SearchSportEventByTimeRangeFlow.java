package com.ufmg.tennisscore.flow.getsportevent;

import com.ufmg.tennisscore.mapper.ResponseMapper;
import com.ufmg.tennisscore.model.entity.SportEvent;
import com.ufmg.tennisscore.model.request.SearchSportEventRequest;
import com.ufmg.tennisscore.model.response.SportEventResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SearchSportEventByTimeRangeFlow {
    private final SearchSportEventByTimeRangeFlowItem searchSportEventByTimeRangeFlowItem;
    private final ResponseMapper responseMapper;

    public List<SportEventResponse> search(SearchSportEventRequest searchSportEventRequest) {
        List<SportEvent> sportEvents = searchSportEventByTimeRangeFlowItem.search(
                searchSportEventRequest.getInitialDate(), searchSportEventRequest.getEndDate());
        return responseMapper.toResponse(sportEvents);
    }
}
