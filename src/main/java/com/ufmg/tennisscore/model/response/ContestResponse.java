package com.ufmg.tennisscore.model.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ContestResponse {
    private String name;
}
