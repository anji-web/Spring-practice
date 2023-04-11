package com.marketplace.practice.marketplacepractice.controller;

import com.marketplace.practice.marketplacepractice.dto.Category.Requests.CreateTipeProductDTO;
import com.marketplace.practice.marketplacepractice.dto.Category.Response.TipeProductResponse;
import com.marketplace.practice.marketplacepractice.model.CategoryProduct;
import com.marketplace.practice.marketplacepractice.model.TipeProduct;
import com.marketplace.practice.marketplacepractice.services.TipeProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("tipe-product")
public class TipeProductController {

  @Autowired
  private TipeProductService tipeProductService;

  @PostMapping("create")
  public ResponseEntity addTipeProduct(@RequestBody CreateTipeProductDTO createTipeProductDTO) {
    TipeProductResponse response = tipeProductService.addJenisProduct(createTipeProductDTO);
    return ResponseEntity.status(201).body(response);
  }

  @GetMapping()
  public ResponseEntity getCategories(){
    return ResponseEntity.ok().body(tipeProductService.getDataList());
  }

  @GetMapping("/product-by-id")
  public ResponseEntity getDataById(@RequestParam("productId") int productId) {
    return ResponseEntity.ok().body(tipeProductService.getProductById(productId));
  }

  @PutMapping("edit")
  public ResponseEntity update(@RequestBody TipeProduct productId) {
    return ResponseEntity.ok().body(tipeProductService.update(productId));
  }

  @DeleteMapping()
  public ResponseEntity delete(@RequestParam("categoryId") int productId) {
    return ResponseEntity.ok().body(tipeProductService.delete(productId));
  }

//  @GetMapping("/product-by-id")
//
//  @PutMapping("edit")
//
//  @DeleteMapping()


}
