package com.ufmg.tennisscore.model.listenerevent;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ufmg.tennisscore.model.enums.GameEventType;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDateTime;

@Data
@ToString
public class GameEvent {
    private GameEventType type;
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS")
    private LocalDateTime dateTime;
    private String description;
    private String contest;
}