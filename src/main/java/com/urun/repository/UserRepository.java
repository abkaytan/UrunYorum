package com.urun.repository;


import com.urun.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
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
            "WHERE e.email = ?1")
    boolean existsByEmail(String email);
}
