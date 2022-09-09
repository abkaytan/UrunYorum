package com.urun.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Log4j2
@Builder
public class UserDto {

    private String name;
    private String lastName;
    private String email;
    private long phoneNumber;
}
