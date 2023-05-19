package com.springboot.Dto;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductsDto {
    private String productName;
    private  Double price;
    private  String  measuringUnits;
    private  Long quantity;
    private  String Description;
    private  boolean isPresent;


}
