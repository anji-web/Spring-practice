package com.marketplace.practice.marketplacepractice.controller;

import com.marketplace.practice.marketplacepractice.dto.Category.Requests.CreateTipeProductDTO;
import com.marketplace.practice.marketplacepractice.dto.Category.Response.TipeProductResponse;
import com.marketplace.practice.marketplacepractice.services.TipeProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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

}
