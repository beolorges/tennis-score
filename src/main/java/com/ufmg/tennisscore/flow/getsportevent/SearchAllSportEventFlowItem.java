package com.ufmg.tennisscore.flow.getsportevent;

import com.ufmg.tennisscore.model.entity.SportEvent;
import com.ufmg.tennisscore.repositories.SportEventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SearchAllSportEventFlowItem {
    private final SportEventRepository sportEventRepository;

    public List<SportEvent> search(){
        return (List<SportEvent>) sportEventRepository.findAll();
    }
}
