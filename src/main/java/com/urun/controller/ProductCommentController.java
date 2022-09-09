package com.urun.controller;

import com.urun.dto.ProductCommentDto;
import com.urun.entity.ProductComment;
import com.urun.service.Impl.ProductCommentServiceImpl;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;


@RestController
@RequestMapping("/comments")
public class ProductCommentController {

    private final ProductCommentServiceImpl productCommentServiceImpl;

    public ProductCommentController(ProductCommentServiceImpl productCommentService) {
        this.productCommentServiceImpl = productCommentService;
    }

    @PostMapping("/save-comment")
    public ResponseEntity<ProductComment> saveComment(@RequestBody ProductCommentDto productCommentDto) {
        ProductComment productComment = productCommentServiceImpl.saveComment(productCommentDto);
        return new ResponseEntity<>(productComment, HttpStatus.OK);
    }

    @GetMapping("/product-id/{productId}")
    public ResponseEntity<List<ProductComment>> findAllCommentsForOneProductByProductId (@PathVariable long productId){
        List<ProductComment> productCommentList = productCommentServiceImpl.findAllCommentsForOneProduct(productId);
        return new ResponseEntity<>(productCommentList, HttpStatus.OK);
    }

    @GetMapping("/product-id/{productId}/{firstDate}/{secondDate}")
    public ResponseEntity<List<ProductComment>> findAllCommentsForOneProductByProductIdWithDate (@PathVariable long productId,
                                                                                                 @PathVariable @DateTimeFormat(pattern = "dd.MM.yyyy HH:mm:ss") Date firstDate,
                                                                                                 @PathVariable @DateTimeFormat(pattern = "dd.MM.yyyy HH:mm:ss") Date secondDate){
        List<ProductComment> productCommentList = productCommentServiceImpl.findAllCommentsForOneProductWithDate(productId, firstDate, secondDate);
        return new ResponseEntity<>(productCommentList, HttpStatus.OK);
    }

    @GetMapping("/user-id/{userId}")
    public ResponseEntity<List<ProductComment>> findAllCommentsForOneProductByUserId (@PathVariable long userId){
        List<ProductComment> productCommentList = productCommentServiceImpl.findAllCommentsForUser(userId);
        return new ResponseEntity<>(productCommentList, HttpStatus.OK);
    }

    @GetMapping("/user-id/{userId}/{firstDate}/{secondDate}")
    public ResponseEntity<List<ProductComment>> findAllCommentsForOneProductByUserIdWithDate (@PathVariable long userId,
                                                                                                 @PathVariable @DateTimeFormat(pattern = "dd.MM.yyyy HH:mm:ss") Date firstDate,
                                                                                                 @PathVariable @DateTimeFormat(pattern = "dd.MM.yyyy HH:mm:ss") Date secondDate){
        List<ProductComment> productCommentList = productCommentServiceImpl.findAllCommentsForUserWithDate(userId, firstDate, secondDate);
        return new ResponseEntity<>(productCommentList, HttpStatus.OK);
    }

}
