package com.vdvorak.spring.react.webflux.aggregation.model;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
public class Promotion {
    private String type;
    private Double discount;
    private LocalDate endDate;

}
