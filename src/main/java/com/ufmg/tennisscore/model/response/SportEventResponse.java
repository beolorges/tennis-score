package com.ufmg.tennisscore.model.response;

import com.ufmg.tennisscore.model.enums.EventPhase;
import lombok.Builder;
import lombok.Data;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
public class SportEventResponse {
    private LocalDateTime dateTime;
    private EventPhase eventPhase;
    private ContestResponse contest;
    private StadiumResponse stadium;
    private Duration timeToEvent;
    private List<ContenderResponse> contenders;
}
