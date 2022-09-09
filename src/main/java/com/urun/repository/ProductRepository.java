package com.urun.repository;


import com.urun.entity.Product;
import com.urun.entity.ProductComment;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
    @Query("SELECT c FROM Product c WHERE c.expireDate< ?1")
    List<Product> findProductsExpired(Date date);

    @Query("SELECT c FROM Product c WHERE c.expireDate> ?1 OR c.expireDate is null")
    List<Product> findProductsNotExpired(Date date);
}
