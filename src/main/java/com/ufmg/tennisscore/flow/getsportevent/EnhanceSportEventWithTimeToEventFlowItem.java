package com.ufmg.tennisscore.flow.getsportevent;

import com.ufmg.tennisscore.model.response.SportEventResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class EnhanceSportEventWithTimeToEventFlowItem implements EnhanceSportEventFlowItem{

    @Override
    public void enhance(SportEventResponse sportEventResponse) {
        Duration timeToEvent = Duration.between(LocalDateTime.now(), sportEventResponse.getDateTime());
        sportEventResponse.setTimeToEvent(timeToEvent);
    }
}
