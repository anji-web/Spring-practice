package com.marketplace.practice.marketplacepractice.repo;

import com.marketplace.practice.marketplacepractice.model.CategoryProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CategoryRepo extends JpaRepository<CategoryProduct, Integer> {

  @Query(value = "select category_id from category_product where category_name = ?1", nativeQuery = true)
  public int getCategoryId(String categoryName);



}
