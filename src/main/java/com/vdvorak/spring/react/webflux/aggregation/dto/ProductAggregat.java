package com.vdvorak.spring.react.webflux.aggregation.dto;

import com.vdvorak.spring.react.webflux.aggregation.model.Product;
import com.vdvorak.spring.react.webflux.aggregation.model.Promotion;
import com.vdvorak.spring.react.webflux.aggregation.model.Review;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor(staticName = "create")
public class ProductAggregat {

    private Product product;
    private Promotion promotion;
    private List<Review> reviews;

}
