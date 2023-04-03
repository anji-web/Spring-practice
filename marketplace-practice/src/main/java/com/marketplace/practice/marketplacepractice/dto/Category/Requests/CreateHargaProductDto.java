package com.marketplace.practice.marketplacepractice.dto.Category.Requests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateHargaProductDto {

    private String currency;
    private double priceProduct;
}
