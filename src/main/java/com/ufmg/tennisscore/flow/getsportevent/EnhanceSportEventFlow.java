package com.ufmg.tennisscore.flow.getsportevent;

import com.ufmg.tennisscore.mapper.ResponseMapper;
import com.ufmg.tennisscore.model.entity.SportEvent;
import com.ufmg.tennisscore.model.response.SportEventResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EnhanceSportEventFlow {
    private final List<EnhanceSportEventFlowItem> enhanceSportEventFlowItems;
    private final ResponseMapper responseMapper;

    public SportEventResponse enhance(SportEvent sportEvent){
        SportEventResponse sportEventResponse = responseMapper.toResponse(sportEvent);
        enhanceSportEventFlowItems.stream()
                .filter(EnhanceSportEventFlowItem::isApplicable)
                .forEach(enhanceSportEventFlowItem -> enhanceSportEventFlowItem.enhance(sportEventResponse));

        return sportEventResponse;
    }

}
