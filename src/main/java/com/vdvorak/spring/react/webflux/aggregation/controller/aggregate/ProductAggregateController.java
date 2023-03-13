package com.vdvorak.spring.react.webflux.aggregation.controller.aggregate;

import com.vdvorak.spring.react.webflux.aggregation.dto.ProductAggregat;
import com.vdvorak.spring.react.webflux.aggregation.services.aggregate.ProductAggregatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("product")
public class ProductAggregateController {


    @Autowired
    private ProductAggregatorService service;

    @GetMapping("{productId}")
    public Mono<ResponseEntity<ProductAggregat>> getProduct(@PathVariable Integer productId){
        return this.service.getProduct(productId)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

}
