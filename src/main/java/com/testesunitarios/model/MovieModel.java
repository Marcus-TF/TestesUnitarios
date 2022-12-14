package com.testesunitarios.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MovieModel {

    private String name;

    private Integer inventory;

    private Double price;
}
