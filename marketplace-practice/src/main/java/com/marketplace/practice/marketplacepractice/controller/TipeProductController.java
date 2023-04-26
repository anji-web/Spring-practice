package com.marketplace.practice.marketplacepractice.controller;

import com.marketplace.practice.marketplacepractice.dto.Category.Requests.CreateTipeProductDTO;
import com.marketplace.practice.marketplacepractice.dto.Category.Response.TipeProductResponse;
import com.marketplace.practice.marketplacepractice.model.TipeProduct;
import com.marketplace.practice.marketplacepractice.repo.TipeProductRepo;
import com.marketplace.practice.marketplacepractice.services.TipeProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("tipe-product")
public class TipeProductController {

  @Autowired
  private TipeProductService tipeProductService;
  @Autowired
  private TipeProductRepo tipeProductRepo;

  @PostMapping("create")
  public ResponseEntity addTipeProduct(@RequestBody CreateTipeProductDTO createTipeProductDTO) {
    TipeProductResponse response = tipeProductService.addJenisProduct(createTipeProductDTO);
    return ResponseEntity.status(201).body(response);
  }

  @GetMapping("getTipeProduct")
  public List<TipeProduct> findJenisProduct(){
    return tipeProductService.getJenisProduct();
  }

  @PutMapping("update")
  public TipeProduct updateTipeProduct(@RequestBody TipeProduct tipeProduct){
    return tipeProductService.update(tipeProduct);
  }
}
