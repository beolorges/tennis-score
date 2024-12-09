package com.ufmg.tennisscore.flow.getsportevent;

import com.ufmg.tennisscore.model.entity.SportEvent;
import com.ufmg.tennisscore.model.request.SearchSportEventRequest;
import com.ufmg.tennisscore.repositories.SportEventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SearchSportEventByAllParamsFlowItem {
    private final SportEventRepository sportEventRepository;

    public List<SportEvent> search(SearchSportEventRequest searchSportEventRequest){
       return sportEventRepository.findAllByDateTimeBetweenAndContest_Name(
               searchSportEventRequest.getInitialDate(), searchSportEventRequest.getEndDate(), searchSportEventRequest.getContest());
    }
}
