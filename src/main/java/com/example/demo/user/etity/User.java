package com.example.demo.user.etity;


import com.example.demo.user.service.UserReponse;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
//import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user_")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "createDate")
    private LocalDateTime createDate;

    @Column(name = "modifiedDate")
    private LocalDateTime modifiedDate;

    @Column(name = "password")
    private String password;

    @Column(name = "username")
    private String username;

    @Column(name = "emailAddress")
    private String emailAddress;

    @Column(name = "displayName")
    private String displayName;

    @Column(name = "organization_id")
    private String organizationId;

    @Column(name = "lastLoginDate")
    private LocalDateTime lastLoginDate;

    @Column(name = "lastLoginIP")
    private String lastLoginIP;

    @Column(name = "status")
    private String status;

    @Column(name = "sso")
    private String sso;




    public UserReponse toResponse(){
        return new UserReponse(id,createDate,modifiedDate,password,username,emailAddress,displayName,organizationId,lastLoginDate,lastLoginIP,status,sso);
    }





}
