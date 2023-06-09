package com.marketplace.practice.marketplacepractice.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TipeProduct extends BaseModel
{

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int idProduct;

  private String namaProduct;
  private String description;
  private int idKategori;

  private String kategoriProduct;

}
