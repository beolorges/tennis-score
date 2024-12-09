package com.ufmg.tennisscore.flow.getsportevent;

import com.ufmg.tennisscore.model.entity.SportEvent;
import com.ufmg.tennisscore.repositories.SportEventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SearchSportEventByTimeRangeFlowItem {
    private final SportEventRepository sportEventRepository;

    public List<SportEvent> search(LocalDateTime initialDate, LocalDateTime endDate){
        return sportEventRepository.findAllByDateTimeBetween(initialDate, endDate);
    }
}
