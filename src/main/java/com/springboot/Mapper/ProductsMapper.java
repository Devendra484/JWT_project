package com.springboot.Mapper;

import com.springboot.Dto.ProductsDto;
import com.springboot.Model.Products;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductsMapper {

    @Autowired
    private ModelMapper modelMapper;

    public ProductsDto toDto(Products products){
        return  modelMapper.map(products, ProductsDto.class);
    }
    public  List<ProductsDto> productsDtoList(List<Products> productsList){
        return  productsList.stream().map(this::toDto).collect(Collectors.toList());
    }
}
