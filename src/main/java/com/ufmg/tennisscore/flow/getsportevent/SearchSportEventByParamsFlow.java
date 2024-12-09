package com.ufmg.tennisscore.flow.getsportevent;

import com.ufmg.tennisscore.model.request.SearchSportEventRequest;
import com.ufmg.tennisscore.model.response.SportEventResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SearchSportEventByParamsFlow {
    private final SearchSportEventByTimeRangeFlow searchSportEventByTimeRangeFlow;
    private final SearchSportEventByEndDateFlow searchSportEventByEndDateFlow;
    private final SearchSportEventByInitialDateFlow searchSportEventByInitialDateFlow;
    private final SearchSportEventByContestFlow searchSportEventByContestFlow;
    private final SearchAllSportEventFlow searchAllSportEventFlow;
    private final SearchSportEventByAllParamsFlow searchSportEventByAllParams;

    public List<SportEventResponse> search(SearchSportEventRequest searchSportEventRequest){
        if(searchSportEventRequest.getInitialDate() != null){
            if(searchSportEventRequest.getEndDate() != null){
                if(searchSportEventRequest.getContest() != null){
                   return searchSportEventByAllParams.search(searchSportEventRequest);
                }
                return searchSportEventByTimeRangeFlow.search(searchSportEventRequest);
            }
           return searchSportEventByInitialDateFlow.search(searchSportEventRequest.getInitialDate());
        }
        if(searchSportEventRequest.getEndDate() != null){
            return searchSportEventByEndDateFlow.search(searchSportEventRequest.getEndDate());
        }

        if(searchSportEventRequest.getContest() != null){
            return searchSportEventByContestFlow.search(searchSportEventRequest.getContest());
        }

        return searchAllSportEventFlow.search();

    }
}
