package com.ufmg.tennisscore.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StadiumResponse {
    private String zipCode;
    private String name;
    private int capacity;
    private String siteUrl;
}
