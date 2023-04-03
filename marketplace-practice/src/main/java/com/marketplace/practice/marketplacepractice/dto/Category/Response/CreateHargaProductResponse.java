package com.marketplace.practice.marketplacepractice.dto.Category.Response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateHargaProductResponse {

    private int productId;
    private int priceId;
    private String currency;
    private double priceProduct;
}
