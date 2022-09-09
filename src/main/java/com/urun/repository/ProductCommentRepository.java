package com.urun.repository;


import com.urun.entity.ProductComment;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ProductCommentRepository extends CrudRepository<ProductComment, Long> {
    @Query("SELECT " +
            "  CASE " +
            "   WHEN " +
            "       COUNT(e)>0 " +
            "   THEN " +
            "       TRUE " +
            "   ELSE " +
            "       FALSE " +
            "   END " +
            "FROM User e " +
            "WHERE e.id = ?1")
    boolean existsByUserId(long id);

    @Query("SELECT " +
            "  CASE " +
            "   WHEN " +
            "       COUNT(e)>0 " +
            "   THEN " +
            "       TRUE " +
            "   ELSE " +
            "       FALSE " +
            "   END " +
            "FROM Product e " +
            "WHERE e.id = ?1")
    boolean existsByProductId(long id);

    @Query("SELECT c FROM ProductComment c WHERE c.productId= ?1")
    List<ProductComment> findProductCommentByProductId(long id);

    @Query("SELECT c FROM ProductComment c WHERE c.productId= ?1 AND c.commentDate BETWEEN ?2 AND ?3")
    List<ProductComment> findProductCommentByProductIdWithDate(long id, Date firstDate, Date secondDate);

    @Query("SELECT c FROM ProductComment c WHERE c.userId= ?1")
    List<ProductComment> findProductCommentByUserId(long id);

    @Query("SELECT c FROM ProductComment c WHERE c.userId= ?1 AND c.commentDate BETWEEN ?2 AND ?3")
    List<ProductComment> findProductCommentByUserIdWithDate(long id, Date firstDate, Date secondDate);
}
