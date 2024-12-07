package com.ufmg.tennisscore.model.response;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ContenderResponse {
    private String name;
    private LocalDate birthDay;
}
