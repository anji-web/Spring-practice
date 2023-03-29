package com.marketplace.practice.marketplacepractice.repo;

import com.marketplace.practice.marketplacepractice.model.CategoryProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository<CategoryProduct, Integer> {



}
