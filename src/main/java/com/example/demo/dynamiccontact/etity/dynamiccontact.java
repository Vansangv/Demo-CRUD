package com.example.demo.dynamiccontact.etity;


import com.example.demo.dynamiccontact.service.dynamiccontactResponse;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "edoc_dynamiccontact")

public class dynamiccontact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "in_charge")
    private String charge;

    @Column(name = "domain")
    private String domain;

    @Column(name = "email")
    private String email;

    @Column(name = "address")
    private String address;

    @Column(name = "telephone")
    private String telephone;

    @Column(name = "website")
    private String website;

    @Column(name = "type")
    private String type;

    @Column(name = "version")
    private String version;

    @Column(name = "status")
    private String status;

    @Column(name = "token")
    private String token;

    @Column(name = "parent")
    private String parent;

    @Column(name = "agency")
    private String agency;

    public dynamiccontactResponse toResponse(){
        return new dynamiccontactResponse(id,name,charge,domain,email,address,telephone,website,type,version,status,token,parent,agency);
    }

}
