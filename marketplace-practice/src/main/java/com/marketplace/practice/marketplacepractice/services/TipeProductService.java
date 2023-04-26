package com.marketplace.practice.marketplacepractice.services;

import com.marketplace.practice.marketplacepractice.dto.Category.Requests.CreateTipeProductDTO;
import com.marketplace.practice.marketplacepractice.dto.Category.Response.TipeProductResponse;
import com.marketplace.practice.marketplacepractice.model.CategoryProduct;
import com.marketplace.practice.marketplacepractice.model.TipeProduct;
import com.marketplace.practice.marketplacepractice.repo.CategoryRepo;
import com.marketplace.practice.marketplacepractice.repo.TipeProductRepo;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TipeProductService {

  @Autowired
  private TipeProductRepo tipeProductRepo;

  @Autowired
  private CategoryRepo categoryRepo;

  public TipeProductResponse addJenisProduct(CreateTipeProductDTO createTipeProductDTO) {

//    request
    TipeProduct tipeProduct = new TipeProduct();
    tipeProduct.setNamaProduct(createTipeProductDTO.getNamaProduct());
    tipeProduct.setDescription(createTipeProductDTO.getDescription());
    tipeProduct.setCreated_at(new Date());
    tipeProduct.setUpdated_at(new Date());

    int kategoriId = categoryRepo.getCategoryId(createTipeProductDTO.getKategoriProduct());

    tipeProduct.setIdKategori(kategoriId);

    tipeProductRepo.save(tipeProduct);

//    response
    TipeProductResponse response = new TipeProductResponse();
    response.setNamaProduct(createTipeProductDTO.getNamaProduct());
    response.setDescription(createTipeProductDTO.getDescription());
    Optional<CategoryProduct> categoryProduct = categoryRepo.findById(kategoriId);
    response.setProductCategory(categoryProduct.get());

    return  response;
  }

  public List<TipeProduct> getJenisProduct(){
    return tipeProductRepo.findAll();
  }

  public TipeProduct update (TipeProduct tipeProduct){
    Optional<TipeProduct> product = tipeProductRepo.findById(tipeProduct.getIdProduct());
    product.get().setNamaProduct(tipeProduct.getNamaProduct());
    product.get().setDescription(tipeProduct.getDescription());
    product.get().setIdKategori(tipeProduct.getIdKategori());
    tipeProduct.setUpdated_at(new Date());
    tipeProductRepo.save(product.get());
    return product.get();
  }

}
