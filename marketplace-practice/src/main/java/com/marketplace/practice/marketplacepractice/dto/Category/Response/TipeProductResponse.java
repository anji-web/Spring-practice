package com.marketplace.practice.marketplacepractice.dto.Category.Response;

import com.marketplace.practice.marketplacepractice.model.CategoryProduct;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TipeProductResponse {

  private int productId;
  private String namaProduct;
  private String description;
  private CategoryProduct productCategory;

  private int statusCode;
  private String result;

}
