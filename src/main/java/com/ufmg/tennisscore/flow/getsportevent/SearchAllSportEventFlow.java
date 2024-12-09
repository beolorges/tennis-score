package com.ufmg.tennisscore.flow.getsportevent;

import com.ufmg.tennisscore.mapper.ResponseMapper;
import com.ufmg.tennisscore.model.entity.SportEvent;
import com.ufmg.tennisscore.model.response.SportEventResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SearchAllSportEventFlow {
    private final SearchAllSportEventFlowItem searchAllSportEventFlowItem;
    private final ResponseMapper responseMapper;

    public List<SportEventResponse> search(){
        List<SportEvent> search = searchAllSportEventFlowItem.search();
        return responseMapper.toResponse(search);
    }
}
