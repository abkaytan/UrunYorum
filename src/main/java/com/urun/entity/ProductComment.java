package com.urun.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Log4j2

@Entity
@Table(name = "product_comments")
public class ProductComment implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "Comment area cant be blank")
    private String comment;

    @CreatedDate
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date commentDate;

    @NotNull(message = " need userId to search")
    private Long userId;

    @NotNull(message = " need productId to search")
    private Long productId;


}
