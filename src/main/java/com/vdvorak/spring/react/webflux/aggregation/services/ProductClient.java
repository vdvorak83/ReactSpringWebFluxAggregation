package com.vdvorak.spring.react.webflux.aggregation.services;

import com.vdvorak.spring.react.webflux.aggregation.model.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class ProductClient {

    private final WebClient client;

    public ProductClient(WebClient.Builder builder) {
        this.client = builder.baseUrl("http://localhost:3000/products/").build();
    }

    public Mono<Product> getProduct(Integer productId){
        return this.client
                .get()
                .uri("{productId}",productId)
                .retrieve()
                .bodyToMono(Product.class)
                .onErrorResume(ex->Mono.empty())
              // .onErrorReturn(Mono.empty())

                ;

    }
}
