package com.marketplace.practice.marketplacepractice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class HargaProduct extends BaseModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int priceId;
    private int productId;
    private String currency;
    private double priceProduct;

}
