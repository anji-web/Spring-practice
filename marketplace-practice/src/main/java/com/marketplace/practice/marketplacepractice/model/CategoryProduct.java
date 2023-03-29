package com.marketplace.practice.marketplacepractice.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class CategoryProduct extends BaseModel {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int categoryId;

  private String categoryName;

  private String test;

}
