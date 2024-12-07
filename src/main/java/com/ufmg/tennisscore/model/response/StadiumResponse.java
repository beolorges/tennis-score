package com.ufmg.tennisscore.model.response;

import lombok.Data;

@Data
public class StadiumResponse {
    private String zipCode;
    private String name;
    private int capacity;
    private String siteUrl;
}
