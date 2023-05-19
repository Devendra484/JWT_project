package com.springboot.Dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UsersRegDto {
    private String userName;
    private  Long phnNumber;
    private  String password;
}
