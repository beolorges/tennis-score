package com.ufmg.tennisscore.model.response;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class ContenderResponse {
    private String name;
    private LocalDate birthDay;
}
