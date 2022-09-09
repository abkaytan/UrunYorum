package com.urun.service;


import com.urun.dto.ProductDto;
import com.urun.entity.Product;

import java.util.Date;
import java.util.List;

public interface ProductService {

    public Product saveProduct(ProductDto productDto);

    public List<Product> findExpiredProducts(Date date);
    public List<Product> findNotExpiredProducts(Date date);

}
