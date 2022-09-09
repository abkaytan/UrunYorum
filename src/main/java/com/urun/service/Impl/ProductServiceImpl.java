package com.urun.service.Impl;


import com.urun.dto.ProductDto;
import com.urun.entity.Product;
import com.urun.repository.ProductRepository;
import com.urun.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;


    @Override
    public Product saveProduct(ProductDto productDto) {
        Product product = new Product();
        product.setProductName(productDto.getProductName());
        product.setProductPrice(productDto.getProductPrice());
        product.setExpireDate(productDto.getExpireDate());
        return productRepository.save(product);
    }

    @Override
    public List<Product> findExpiredProducts(Date date) {
        List<Product> productList = productRepository.findProductsExpired(date);
        return productList;
    }

    @Override
    public List<Product> findNotExpiredProducts(Date date) {
        List<Product> productList = productRepository.findProductsNotExpired(date);
        return productList;
    }
}
