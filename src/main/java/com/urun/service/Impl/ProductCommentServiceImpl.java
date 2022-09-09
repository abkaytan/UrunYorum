package com.urun.service.Impl;


import com.urun.dto.ProductCommentDto;
import com.urun.entity.ProductComment;
import com.urun.exceptions.SameEmailException;
import com.urun.repository.ProductCommentRepository;
import com.urun.repository.UserRepository;
import com.urun.service.ProductCommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


@Service
@RequiredArgsConstructor
public class ProductCommentServiceImpl implements ProductCommentService {

    private final ProductCommentRepository productCommentRepository;




    @Override
    public ProductComment saveComment(ProductCommentDto productCommentDto) {
        ProductComment productComment = new ProductComment();
        productComment.setComment(productCommentDto.getComment());
        productComment.setUserId(productCommentDto.getUserId());
        productComment.setProductId(productCommentDto.getProductId());
        boolean isExistUserId = productCommentRepository.existsByUserId(productComment.getUserId());
        if (!isExistUserId) {
            throw new SameEmailException("There is no user with this id: " + productComment.getUserId());
        }
        boolean isExistProductId = productCommentRepository.existsByProductId(productComment.getProductId());
        if (!isExistProductId) {
            throw new SameEmailException("There is no product with this id: " + productComment.getProductId());
        }
        return productCommentRepository.save(productComment);
    }

    @Override
    public List<ProductComment> findAllCommentsForOneProduct(Long productId) {
        List<ProductComment> productCommentList = productCommentRepository.findProductCommentByProductId(productId);
        return productCommentList;
    }

    @Override
    public List<ProductComment> findAllCommentsForOneProductWithDate(Long productId, Date firstDate, Date secondDate) {
        return productCommentRepository.findProductCommentByProductIdWithDate(productId, firstDate, secondDate);
    }


    @Override
    public List<ProductComment> findAllCommentsForUser(Long userId) {
        List<ProductComment> productCommentList = productCommentRepository.findProductCommentByUserId(userId);
        return productCommentList;
    }

    @Override
    public List<ProductComment> findAllCommentsForUserWithDate(Long userId, Date firstDate, Date secondDate) {
        return productCommentRepository.findProductCommentByUserIdWithDate(userId, firstDate, secondDate);
    }


}
