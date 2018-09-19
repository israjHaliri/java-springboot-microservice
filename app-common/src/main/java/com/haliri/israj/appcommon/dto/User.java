package com.haliri.israj.appcommon.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {

    public User(Integer id) {
        this.id = id;
    }

    private Integer id;
    private String username;
    private String birthPlace;
    private Date birthDate;
    private String address;
    private BigDecimal bill;
}
