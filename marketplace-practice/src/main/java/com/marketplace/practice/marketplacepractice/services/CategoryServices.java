package com.marketplace.practice.marketplacepractice.services;

import com.marketplace.practice.marketplacepractice.dto.Category.Requests.CreateCategoryDto;
import com.marketplace.practice.marketplacepractice.dto.Category.Response.CreateCategoryResponseDto;
import com.marketplace.practice.marketplacepractice.model.CategoryProduct;
import com.marketplace.practice.marketplacepractice.repo.CategoryRepo;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class CategoryServices {


  @Autowired
  private CategoryRepo categoryRepo;


  public CreateCategoryResponseDto  saveCategory(CreateCategoryDto createCategoryDto) throws Exception {


      if (createCategoryDto.getCategoryName().matches("[0-9]+")) {
            throw new Exception("Category name should be includes alphabetically");
      }

      CategoryProduct categoryProduct = new CategoryProduct();
      categoryProduct.setCategoryName(createCategoryDto.getCategoryName());
      categoryProduct.setCreated_at(new Date());
      categoryProduct.setUpdated_at(new Date());

      try {

        categoryRepo.save(categoryProduct);

      } catch (Exception e) {
          throw new Exception(e.getMessage());
      }

      CreateCategoryResponseDto responseDto = new CreateCategoryResponseDto();
      responseDto.setCategoryId(categoryProduct.getCategoryId());
      responseDto.setCategoryName(categoryProduct.getCategoryName());
      responseDto.setStatusCode(HttpStatus.CREATED.value());
      responseDto.setResult("Category Product created successfully");
      return  responseDto;

  }




}
