package com.example.demo.dynamiccontact.service;

import com.example.demo.dynamiccontact.etity.dynamiccontact;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class dynamiccontactRequest {

    private Integer id;

    @NotBlank(message = "Name không được để trống")
    private String name;

    private String charge;

    private String domain;

    private String email;

    private String address;

    private String telephone;

    private String website;

    private String type;

    private String version;

    private String status;

    private String token;

    private String parent;

    private String agency;

    public dynamiccontact toEntity(){
        return new dynamiccontact(id,name,charge,domain,email,address,telephone,website,type,version,status,token,parent,agency);
    }
}
