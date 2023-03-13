package com.vdvorak.spring.react.webflux.aggregation.services.aggregate;

import com.vdvorak.spring.react.webflux.aggregation.dto.ProductAggregat;
import com.vdvorak.spring.react.webflux.aggregation.model.Product;
import com.vdvorak.spring.react.webflux.aggregation.model.Promotion;
import com.vdvorak.spring.react.webflux.aggregation.model.Review;
import com.vdvorak.spring.react.webflux.aggregation.services.ProductClient;
import com.vdvorak.spring.react.webflux.aggregation.services.PromotionClient;
import com.vdvorak.spring.react.webflux.aggregation.services.ReviewClient;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple3;

@Service
@AllArgsConstructor
public class ProductAggregatorService {

    private final ProductClient productClient;
    private final PromotionClient promotionClient;
    private final ReviewClient reviewClient;


    public Mono<ProductAggregat> getProduct(Integer productId){
        return Mono.zip(
                this.productClient.getProduct(productId),
                this.promotionClient.getPromotion(productId),
                this.reviewClient.getReviews(productId)
        )
                .map(this::combine);
    }

    private ProductAggregat  combine(Tuple3<Product, Promotion, List<Review>> tuple) {
        return  ProductAggregat.create(tuple.getT1(), tuple.getT2(), tuple.getT3());
    }

}
