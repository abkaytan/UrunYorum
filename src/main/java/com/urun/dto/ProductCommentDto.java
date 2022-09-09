package com.urun.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

import javax.validation.constraints.NotBlank;
import java.util.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Log4j2
@Builder
public class ProductCommentDto {

    private String comment;
    private long userId;
    private long productId;
}
