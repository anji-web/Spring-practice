package com.marketplace.practice.marketplacepractice.dto.Category.Requests;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateTipeProductDTO {

  private int productId;

  private String namaProduct;
  private String kategoriProduct;
  private String description;
  private String result;

  private int statusCode;


}
