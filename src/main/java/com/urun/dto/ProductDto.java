package com.urun.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import java.util.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Log4j2
@Builder
public class ProductDto {

    private String productName;
    private double productPrice;


    private Date expireDate;
}
