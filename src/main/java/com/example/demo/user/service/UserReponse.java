package com.example.demo.user.service;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserReponse {

    private Integer id;

    private LocalDateTime createDate;

    private LocalDateTime modifiedDate;

    private String password;

    private String username;

    private String emailAddress;

    private String displayName;

    private String organizationid;

    private LocalDateTime lastLoginDate;

    private String lastLoginIP;

    private String status;

    private String sso;




}
