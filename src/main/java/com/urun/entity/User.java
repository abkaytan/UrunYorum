package com.urun.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.format.annotation.NumberFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Log4j2

@Entity
@Table(name = "users")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "First Name is mandatory")
    private String name;

    @NotBlank(message = "Last Name is mandatory")
    private String lastName;

    @NotBlank(message = " Need Email to sign up")
    private String email;

    @NotNull(message = " Need phone number to sign up")
    private Long phoneNumber;

}
