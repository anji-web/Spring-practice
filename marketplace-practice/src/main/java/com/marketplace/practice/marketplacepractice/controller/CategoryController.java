package com.marketplace.practice.marketplacepractice.controller;


import com.marketplace.practice.marketplacepractice.dto.Category.Requests.CreateCategoryDto;
import com.marketplace.practice.marketplacepractice.dto.Category.Response.CreateCategoryResponseDto;
import com.marketplace.practice.marketplacepractice.model.CategoryProduct;
import com.marketplace.practice.marketplacepractice.services.CategoryServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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


  @GetMapping()
  public ResponseEntity getCategories(){
      return ResponseEntity.ok().body(categoryServices.getDataList());
  }

  @GetMapping("/category-by-id")
  public ResponseEntity getDataById(@RequestParam("categoryId") int categoryId) {
    return ResponseEntity.ok().body(categoryServices.getDataByCategoryId(categoryId));
  }

  @PutMapping("edit")
  public ResponseEntity update(@RequestBody CategoryProduct categoryProduct) {
      return ResponseEntity.ok().body(categoryServices.update(categoryProduct));
  }

  @DeleteMapping()
  public ResponseEntity delete(@RequestParam("categoryId") int categoryId) {
    return ResponseEntity.ok().body(categoryServices.delete(categoryId));
  }
}
