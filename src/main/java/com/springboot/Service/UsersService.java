package com.springboot.Service;

import com.springboot.Dto.UsersLoginDto;
import com.springboot.Dto.UsersRegDto;
import com.springboot.Mapper.UsersMapper;
import com.springboot.Model.Users;
import com.springboot.Repository.UsersRepository;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;


@Service
public class UsersService {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private UsersMapper usersMapper;

    private static  final  String SECRET_KEY="Secret_key";
    private static final long EXPIRATION_TIME_MS = 3600000;


    public  String generateToken(Users users){
        Long currentTimeMillis=System.currentTimeMillis();
        Date now =new Date(currentTimeMillis);
        Date expiryDate=new Date(currentTimeMillis+EXPIRATION_TIME_MS);
        String token= Jwts.builder()
                .setSubject(users.getUserName())
                .setIssuedAt(now)
                .setExpiration(expiryDate)
                .signWith(SignatureAlgorithm.HS256,SECRET_KEY)
                .compact();
        return  token;
    }
    public  Claims validateToken(String token) throws Exception {
        Claims claims=null;
        try {
            claims=Jwts.parser()
                    .setSigningKey(SECRET_KEY)
                    .parseClaimsJws(token)
                    .getBody();
        }
        catch (Exception e){
            System.out.println(claims);
            throw new Exception("token Validation failed");
        }
        return  claims;
    }

    public  String register(UsersRegDto usersReg){
        usersRepository.save(usersMapper.toEntity(usersReg));
        return  "Successfully Registered";
    }
    public  Users login(UsersLoginDto usersLogin){
        Users user=usersRepository.findByUserName(usersMapper.toEntityLogin(usersLogin).getUserName());
       if (user==null) {
           throw new RuntimeException("user Not found");
       } else if (user!=null && usersLogin.getPassword().equals(user.getPassword())) {
           return user;
       }
       else {
           throw new RuntimeException("Wrong credentials");
       }
    }


    public String update(Users users, Long id) {
        Users users1=usersRepository.findById(id).get();
        users1=Users.builder()
                .id(users1.getId())
                .userName(users.getUserName())
                .phnNumber(users.getPhnNumber())
                .password(users.getPassword())
                .createdDate(users1.getCreatedDate())
                .build();
          usersRepository.save(users1);
          return  "updated successfully";
    }
}
