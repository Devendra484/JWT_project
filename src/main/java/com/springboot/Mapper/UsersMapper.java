package com.springboot.Mapper;

import com.springboot.Dto.UsersLoginDto;
import com.springboot.Dto.UsersRegDto;
import com.springboot.Model.Users;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UsersMapper {

    @Autowired
    private   ModelMapper modelMapper ;

    public Users toEntity(UsersRegDto user){
        return  modelMapper.map(user, Users.class);
    }
    public  Users toEntityLogin(UsersLoginDto userLogin){
        return  modelMapper.map(userLogin, Users.class);
    }



}
