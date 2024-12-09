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
public class SearchSportEventByAllParamsFlow {
    private final SearchSportEventByAllParamsFlowItem searchSportEventByAllParamsFlowItem;
    private final ResponseMapper responseMapper;

    public List<SportEventResponse> search(SearchSportEventRequest searchSportEventRequest){
        List<SportEvent> search = searchSportEventByAllParamsFlowItem.search(searchSportEventRequest);
        return responseMapper.toResponse(search);
    }
}
