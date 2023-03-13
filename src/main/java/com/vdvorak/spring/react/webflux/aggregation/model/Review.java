package com.vdvorak.spring.react.webflux.aggregation.model;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Review {
    private String user;
    private Integer rating;
    private String comment;
}
