package com.urun.controller;

import com.urun.dto.ProductDto;
import com.urun.entity.Product;
import com.urun.service.Impl.ProductServiceImpl;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductServiceImpl productServiceImpl;

    public ProductController(ProductServiceImpl productServiceImpl) {
        this.productServiceImpl = productServiceImpl;
    }

    @PostMapping("/save-product")
    public ResponseEntity<Product> saveProduct(@RequestBody ProductDto productDto) {
        Product product = productServiceImpl.saveProduct(productDto);

        return new ResponseEntity<>(product, HttpStatus.OK);

    }

    @GetMapping("/check-expired/{date}")
    public ResponseEntity<List<Product>> expiredProducts(@PathVariable @DateTimeFormat(pattern = "dd.MM.yyyy HH:mm:ss") Date date){
        List<Product> productList = productServiceImpl.findExpiredProducts(date);
        return new ResponseEntity<>(productList, HttpStatus.OK);
    }

    @GetMapping("/check-not-expired/{date}")
    public ResponseEntity<List<Product>> notExpiredProducts(@PathVariable @DateTimeFormat(pattern = "dd.MM.yyyy HH:mm:ss") Date date){
        List<Product> productList = productServiceImpl.findNotExpiredProducts(date);
        return new ResponseEntity<>(productList, HttpStatus.OK);
    }

    /*@GetMapping("/check-expired/{date}")
    public ResponseEntity<List<Product>> expiredProducts(@PathVariable("date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date date){
        List<Product> productList = productServiceImpl.findExpiredProducts(date);
        return new ResponseEntity<>(productList, HttpStatus.OK);
    }

    @GetMapping("/check-not-expired/{date}")
    public ResponseEntity<List<Product>> notExpiredProducts(@PathVariable("date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date date){
        List<Product> productList = productServiceImpl.findNotExpiredProducts(date);
        return new ResponseEntity<>(productList, HttpStatus.OK);
    }*/




}
