package com.springboot.Controller;

import com.springboot.Dto.ProductsDto;
import com.springboot.Service.ProductsService;
import com.springboot.Service.UsersService;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/prod")
public class ProductsController {
    @Autowired
    private ProductsService productsService;

    @Autowired
    private UsersService usersService;

    @GetMapping("/list")
    public ResponseEntity<Object> productsList(@RequestHeader String authorization) {
        String token = authorization.substring("Bearer".length());
        Claims claims = null;
        Map<String, Object> response = new HashMap<String, Object>();
        try {
            claims = usersService.validateToken(token);
            System.out.println(claims);

            String username = claims.getSubject();
            List<ProductsDto> productsList = productsService.productsList();

            response.put("body", productsList);


        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.UNAUTHORIZED);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> products(@RequestHeader String authorization, @PathVariable Long id) {
        String token = authorization.substring("Bearer".length());
        Claims claims = null;
        Map<String, Object> response = new HashMap<String, Object>();
        try {
            claims = usersService.validateToken(token);
            System.out.println(claims);

            String username = claims.getSubject();
            ProductsDto productsList = productsService.products(id);

            response.put("body", productsList);


        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.UNAUTHORIZED);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);

    }
}
