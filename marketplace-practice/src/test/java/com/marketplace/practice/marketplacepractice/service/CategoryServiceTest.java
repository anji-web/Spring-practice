package com.marketplace.practice.marketplacepractice.service;


import com.marketplace.practice.marketplacepractice.dto.Category.Requests.CreateCategoryDto;
import com.marketplace.practice.marketplacepractice.model.CategoryProduct;
import com.marketplace.practice.marketplacepractice.repo.CategoryRepo;
import com.marketplace.practice.marketplacepractice.services.CategoryServices;
import java.util.Date;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class CategoryServiceTest {

  @InjectMocks
  CategoryServices categoryServices;

  @Mock
  CategoryRepo categoryRepo;


  @Test
  void addCategory() throws Exception {
    CreateCategoryDto categoryProduct = new CreateCategoryDto();
    categoryProduct.setCategoryName("Sapu");

    categoryServices.saveCategory(categoryProduct);

  }


}
