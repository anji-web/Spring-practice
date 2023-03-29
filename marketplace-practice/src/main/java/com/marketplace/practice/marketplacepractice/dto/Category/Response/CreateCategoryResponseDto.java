package com.marketplace.practice.marketplacepractice.dto.Category.Response;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateCategoryResponseDto {

  private int categoryId;
  private String categoryName;
  private int statusCode;
  private String result;


}
