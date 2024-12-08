package com.ufmg.tennisscore.model.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StadiumResponse {
    private String zipCode;
    private String name;
    private int capacity;
    private String siteUrl;
}
