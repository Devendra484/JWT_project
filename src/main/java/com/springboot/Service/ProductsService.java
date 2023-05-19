package com.springboot.Service;

import com.springboot.Dto.ProductsDto;
import com.springboot.Mapper.ProductsMapper;
import com.springboot.Model.Products;
import com.springboot.Repository.ProductsRepository;
import jakarta.persistence.Access;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ProductsService {
    @Autowired
    private ProductsRepository productsRepository;

    @Autowired
    private ProductsMapper productsMapper;

    public List<ProductsDto> productsList(){
        return  productsMapper.productsDtoList((productsRepository.findAll()));
    }

    public ProductsDto products(Long id){
        return  productsMapper.toDto(productsRepository.findById(id).get());
    }
}
