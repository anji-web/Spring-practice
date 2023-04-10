package com.marketplace.practice.marketplacepractice;

import com.marketplace.practice.marketplacepractice.model.CategoryProduct;
import java.util.Date;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MarketplacePracticeApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void testProduct() {

		CategoryProduct categoryProduct = new CategoryProduct();
		categoryProduct.setCategoryName("Kipas angin");
		categoryProduct.setCreated_at(new Date());
		categoryProduct.setUpdated_at(new Date());

		Assertions.assertNotNull(categoryProduct.getCategoryName());
		Assertions.assertNotNull(categoryProduct.getCategoryId());
		Assertions.assertNotNull(categoryProduct.getCreated_at());
		Assertions.assertNotNull(categoryProduct.getUpdated_at());
	}




}
