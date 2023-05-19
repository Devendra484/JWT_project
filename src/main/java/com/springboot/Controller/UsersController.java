package com.springboot.Controller;

import com.springboot.Dto.ProductsDto;
import com.springboot.Dto.UsersLoginDto;
import com.springboot.Dto.UsersRegDto;
import com.springboot.Model.Users;
import com.springboot.Service.ProductsService;
import com.springboot.Service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UsersController {

    @Autowired
    private UsersService usersService;

    @PostMapping("/signin")
    public  String signin(@RequestBody UsersRegDto usersReg){
        return  usersService.register(usersReg);
    }

    @PutMapping ("/up/{id}")
    public String  update(@RequestBody Users users,@PathVariable Long id){
        return  usersService.update(users,id);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody UsersLoginDto usersLogin){
       Users user=usersService.login(usersLogin);
       if(user!=null){
           String token= usersService.generateToken(user);
           return  ResponseEntity.ok(token);
       }
       else {
           return  ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
       }
    }


}
