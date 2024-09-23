package com.example.demo.user.service;

import com.example.demo.user.etity.User;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UsertRequest {

    private Integer id;

    private LocalDateTime createDate;

    private LocalDateTime modifiedDate;
    @NotBlank(message = "password không được để trống")
    private String password;
    @NotBlank(message = "username không được để trống")
    private String username;

    private String emailAddress;

    private String displayName;

    private String organizationid;

    private LocalDateTime lastLoginDate;

    private String lastLoginIP;

    private String status;

    private String sso;

    public User toEntity(){
        return new User(id,createDate,modifiedDate,password,username,emailAddress,displayName,organizationid,lastLoginDate,lastLoginIP,status,sso);
    }



}
