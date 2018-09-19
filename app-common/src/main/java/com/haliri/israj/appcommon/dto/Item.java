package com.haliri.israj.appcommon.dto;

import lombok.*;

import java.math.BigDecimal;
import java.util.Date;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Item {

    public Item(Integer id) {
        this.id = id;
    }

    private Integer id;
    private String title;
    private String description;
    private Integer amount;
    private BigDecimal price;
}
