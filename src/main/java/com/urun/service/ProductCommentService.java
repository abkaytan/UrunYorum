package com.urun.service;


import com.urun.dto.ProductCommentDto;
import com.urun.entity.ProductComment;

import java.util.Date;
import java.util.List;

public interface ProductCommentService {

    public ProductComment saveComment(ProductCommentDto productCommentDto);

    public List<ProductComment> findAllCommentsForOneProduct(Long productId);
    public List<ProductComment> findAllCommentsForOneProductWithDate(Long productId, Date firstDate, Date secondDate);

    public List<ProductComment> findAllCommentsForUser(Long userId);
    public List<ProductComment> findAllCommentsForUserWithDate(Long userId, Date firstDate, Date secondDate);

}
