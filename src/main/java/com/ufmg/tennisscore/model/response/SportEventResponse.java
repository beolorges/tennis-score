package com.ufmg.tennisscore.model.response;

import com.ufmg.tennisscore.model.entity.Contest;
import com.ufmg.tennisscore.model.entity.Stadium;
import com.ufmg.tennisscore.model.enums.EventPhase;
import lombok.Data;

import java.time.Duration;
import java.time.LocalDateTime;

@Data
public class SportEventResponse {
    private LocalDateTime dateTime;
    private EventPhase eventPhase;
    private Contest contest;
    private Stadium stadium;
    private Duration timeToEvent;
}
