package com.ufmg.tennisscore.model.response;

import com.ufmg.tennisscore.model.enums.EventPhase;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SportEventResponse {
    private LocalDateTime dateTime;
    private EventPhase eventPhase;
    private ContestResponse contest;
    private StadiumResponse stadium;
    private Duration timeToEvent;
    private List<ContenderResponse> contenders;
}
