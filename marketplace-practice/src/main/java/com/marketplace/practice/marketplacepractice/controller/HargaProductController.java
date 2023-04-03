package com.marketplace.practice.marketplacepractice.controller;

import com.marketplace.practice.marketplacepractice.dto.Category.Requests.CreateHargaProductDto;
import com.marketplace.practice.marketplacepractice.dto.Category.Response.CreateHargaProductResponse;
import com.marketplace.practice.marketplacepractice.services.HargaProductServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("hargaproduct")
public class HargaProductController {

    @Autowired
    private HargaProductServices services;
    @PostMapping("create")
    public CreateHargaProductResponse addCurrency(@RequestBody CreateHargaProductDto createHargaProductDto){
        return services.saveCurrency(createHargaProductDto);
    }
}
