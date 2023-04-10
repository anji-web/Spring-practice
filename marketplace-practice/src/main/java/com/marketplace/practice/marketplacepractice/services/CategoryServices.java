package com.marketplace.practice.marketplacepractice.services;

import com.marketplace.practice.marketplacepractice.dto.Category.Requests.CreateCategoryDto;
import com.marketplace.practice.marketplacepractice.dto.Category.Response.CreateCategoryResponseDto;
import com.marketplace.practice.marketplacepractice.model.CategoryProduct;
import com.marketplace.practice.marketplacepractice.repo.CategoryRepo;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
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

  public List<CreateCategoryResponseDto> getDataList() {
    List<CategoryProduct> categoryProducts = categoryRepo.findAll(); //select * from CategoryProduct
    List<CreateCategoryResponseDto> responseDtoList = new ArrayList<>();

    for (CategoryProduct cp : categoryProducts ) {
        CreateCategoryResponseDto responseDto = new CreateCategoryResponseDto();
        responseDto.setCategoryId(cp.getCategoryId());
        responseDto.setCategoryName(cp.getCategoryName());
        responseDto.setResult("Success");
        responseDto.setStatusCode(HttpStatus.OK.value());
        responseDtoList.add(responseDto);
    }

    return responseDtoList;
  }


  public CreateCategoryResponseDto getDataByCategoryId(int categoryId) {
    CreateCategoryResponseDto responseDto = new CreateCategoryResponseDto();
    Optional<CategoryProduct> categoryProduct = categoryRepo.findById(categoryId); //ambil data dari database menggunakan JPA
    if (categoryProduct.isEmpty()){
      responseDto.setResult("data not found");
      responseDto.setCategoryId(0);
      responseDto.setCategoryName(null);
      responseDto.setStatusCode(HttpStatus.OK.value());
      return responseDto;
    }
    responseDto.setCategoryId(categoryProduct.get().getCategoryId());
    responseDto.setCategoryName(categoryProduct.get().getCategoryName());
    responseDto.setStatusCode(HttpStatus.OK.value());
    responseDto.setResult("Success");

    return responseDto;
  }

  public CategoryProduct update(CategoryProduct categoryProduct) {
        Optional<CategoryProduct> product = categoryRepo.findById(categoryProduct.getCategoryId());
        product.get().setCategoryName(categoryProduct.getCategoryName());
        product.get().setUpdated_at(new Date());
        categoryRepo.save(product.get());
        return product.get();
  }

  public String delete(int categoryId) {
    Optional<CategoryProduct> product = categoryRepo.findById(categoryId);
    categoryRepo.delete(product.get());

    return "deleted successfully";
  }



}
