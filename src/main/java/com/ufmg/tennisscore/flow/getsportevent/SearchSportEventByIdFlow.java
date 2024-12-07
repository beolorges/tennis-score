package com.ufmg.tennisscore.flow.getsportevent;

import com.ufmg.tennisscore.exceptions.SportEventNotFoundException;
import com.ufmg.tennisscore.model.entity.SportEvent;
import com.ufmg.tennisscore.model.response.SportEventResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SearchSportEventByIdFlow {
    private final SearchSportEventByIdFlowItem searchSportEventByIdFlowItem;
    private final EnhanceSportEventFlow enhanceSportEventFlow;

    public SportEventResponse search(int id){
        SportEvent sportEvent = searchSportEventByIdFlowItem.search(id).orElseThrow(
                () -> new SportEventNotFoundException(id)
        );
        return enhanceSportEventFlow.enhance(sportEvent);
    }
}
