package com.ufmg.tennisscore.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SearchSportEventRequest {
    private LocalDateTime initialDate;
    private LocalDateTime endDate;
    private String contest;
}
