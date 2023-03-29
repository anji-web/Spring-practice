package com.marketplace.practice.marketplacepractice.controller;


import com.marketplace.practice.marketplacepractice.dto.Category.Requests.CreateCategoryDto;
import com.marketplace.practice.marketplacepractice.dto.Category.Response.CreateCategoryResponseDto;
import com.marketplace.practice.marketplacepractice.services.CategoryServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("category")
public class CategoryController {

  @Autowired
  private CategoryServices categoryServices;


  @PostMapping("create")
  public ResponseEntity addCategory(@RequestBody CreateCategoryDto createCategoryDto) {
      try {
        CreateCategoryResponseDto responseDto = categoryServices.saveCategory(createCategoryDto);
        return ResponseEntity.status(responseDto.getStatusCode()).body(responseDto);
      }catch (Exception e) {
        return ResponseEntity.badRequest().body(e.getMessage());
      }
  }

}
