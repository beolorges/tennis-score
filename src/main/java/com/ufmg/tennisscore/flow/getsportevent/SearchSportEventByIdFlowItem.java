package com.ufmg.tennisscore.flow.getsportevent;

import com.ufmg.tennisscore.model.entity.SportEvent;
import com.ufmg.tennisscore.repositories.SportEventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SearchSportEventByIdFlowItem {
    private final SportEventRepository sportEventRepository;

    public Optional<SportEvent> search(int id){
        return sportEventRepository.findById(id);
    }
}
