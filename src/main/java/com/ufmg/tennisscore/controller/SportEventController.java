package com.ufmg.tennisscore.controller;

import com.ufmg.tennisscore.flow.sportevent.SearchSportEventByIdFlow;
import com.ufmg.tennisscore.model.response.SportEventResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/events")
@RequiredArgsConstructor
public class SportEventController {
    private final SearchSportEventByIdFlow searchSportEventByIdFlow;

    @GetMapping(value = "/{id}")
    public SportEventResponse search(@PathVariable int id){
        return searchSportEventByIdFlow.search(id);
    }
}
