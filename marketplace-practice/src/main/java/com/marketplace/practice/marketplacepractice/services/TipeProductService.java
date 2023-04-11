package com.marketplace.practice.marketplacepractice.services;

import com.marketplace.practice.marketplacepractice.dto.Category.Requests.CreateCategoryDto;
import com.marketplace.practice.marketplacepractice.dto.Category.Requests.CreateTipeProductDTO;
import com.marketplace.practice.marketplacepractice.dto.Category.Response.CreateCategoryResponseDto;
import com.marketplace.practice.marketplacepractice.dto.Category.Response.TipeProductResponse;
import com.marketplace.practice.marketplacepractice.model.CategoryProduct;
import com.marketplace.practice.marketplacepractice.model.TipeProduct;
import com.marketplace.practice.marketplacepractice.repo.CategoryRepo;
import com.marketplace.practice.marketplacepractice.repo.TipeProductRepo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

  public List<CreateTipeProductDTO> getDataList() {
    List<TipeProduct> tipeProduct = tipeProductRepo.findAll(); //select * from CategoryProduct
    List<CreateTipeProductDTO> responseDtoList = new ArrayList<>();

    for (TipeProduct tp : tipeProduct ) {
      CreateTipeProductDTO responseDto = new CreateTipeProductDTO();
      responseDto.setProductId(tp.getIdProduct());
      responseDto.setNamaProduct(tp.getNamaProduct());
      responseDto.setKategoriProduct(tp.getKategoriProduct());
      responseDto.setDescription(tp.getDescription());
      responseDto.setResult("Success");
      responseDto.setStatusCode(HttpStatus.OK.value());
      responseDtoList.add(responseDto);
    }

    return responseDtoList;
  }

  public TipeProductResponse getProductById(int productId) {
    TipeProductResponse responseDto = new TipeProductResponse();
    Optional<TipeProduct> tipeProduct = tipeProductRepo.findById(productId);
    if (tipeProduct.isEmpty()){
      responseDto.setResult("data not found");
      responseDto.setProductId(0);
      responseDto.setNamaProduct(null);
      responseDto.setStatusCode(HttpStatus.OK.value());
      return responseDto;
    }
    responseDto.setProductId(tipeProduct.get().getIdProduct());
    responseDto.setNamaProduct(tipeProduct.get().getNamaProduct());
    responseDto.setStatusCode(HttpStatus.OK.value());
    responseDto.setResult("Success");

    return responseDto;
  }

  public TipeProduct update(TipeProduct tipeProduct) {
    Optional<TipeProduct> product = tipeProductRepo.findById(tipeProduct.getIdProduct());
    product.get().setNamaProduct(tipeProduct.getNamaProduct());
    product.get().setUpdated_at(new Date());
    tipeProductRepo.save(product.get());
    return product.get();
  }

  public String delete(int productId) {
    Optional<TipeProduct> product = tipeProductRepo.findById(productId);
    tipeProductRepo.delete(product.get());

    return "deleted successfully";
  }


}
