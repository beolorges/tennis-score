package com.ufmg.tennisscore.controller;

import com.ufmg.tennisscore.flow.getsportevent.SearchSportEventByParamsFlow;
import com.ufmg.tennisscore.flow.getsportevent.SearchSportEventByIdFlow;
import com.ufmg.tennisscore.flow.getsportevent.SearchSportEventByTimeRangeFlow;
import com.ufmg.tennisscore.model.request.SearchSportEventRequest;
import com.ufmg.tennisscore.model.response.SportEventResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/events")
@RequiredArgsConstructor
public class SportEventController {
    private final SearchSportEventByIdFlow searchSportEventByIdFlow;
    private final SearchSportEventByTimeRangeFlow searchSportEventByTimeRangeFlow;
    private final SearchSportEventByParamsFlow searchSportEventByParamsFlow;


    @GetMapping
    public List<SportEventResponse> searchWithParams(@RequestParam Optional<String> contest,
                                                     @RequestParam Optional<LocalDateTime> initialDate,
                                                     @RequestParam Optional<LocalDateTime> endDate){
        SearchSportEventRequest searchSportEventRequest = new SearchSportEventRequest(
                initialDate.orElse(null), endDate.orElse(null), contest.orElse(null));

        return searchSportEventByParamsFlow.search(searchSportEventRequest);
    }

    @GetMapping(value = "/{id}")
    public SportEventResponse search(@PathVariable int id){
        return searchSportEventByIdFlow.search(id);
    }
}
