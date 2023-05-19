package com.springboot.Dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UsersLoginDto {
    private String userName;
    private  String password;
}
