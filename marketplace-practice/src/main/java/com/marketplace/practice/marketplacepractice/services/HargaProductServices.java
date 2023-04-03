package com.marketplace.practice.marketplacepractice.services;

import com.marketplace.practice.marketplacepractice.dto.Category.Requests.CreateHargaProductDto;
import com.marketplace.practice.marketplacepractice.dto.Category.Response.CreateHargaProductResponse;
import com.marketplace.practice.marketplacepractice.model.HargaProduct;
import com.marketplace.practice.marketplacepractice.repo.HargaProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class HargaProductServices {

    @Autowired
    private HargaProductRepo hargaProductRepo;

    public CreateHargaProductResponse saveCurrency(CreateHargaProductDto createHargaProductDto){
        HargaProduct hargaProduct = new HargaProduct();
        hargaProduct.setCurrency(createHargaProductDto.getCurrency());
        hargaProduct.setPriceProduct(createHargaProductDto.getPriceProduct());
        hargaProduct.setCreated_at(new Date());
        hargaProduct.setUpdated_at(new Date());
        hargaProductRepo.save(hargaProduct);

        CreateHargaProductResponse hargaProductResponse = new CreateHargaProductResponse();
        hargaProductResponse.setProductId(hargaProduct.getProductId());
        hargaProductResponse.setPriceId(hargaProduct.getPriceId());
        hargaProductResponse.setCurrency(hargaProduct.getCurrency());
        hargaProductResponse.setPriceProduct(hargaProduct.getPriceProduct());
        return hargaProductResponse;
    }
}
