package com.controlhome.myhome.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "users")
@Data
public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    @Column(name = "cd_name")
    private String userLogin;

    @Column(name = "password")
    private String pass;

    @Column(name = "date_create")
    private Date dateCreated;

    @OneToOne(mappedBy = "user")
    private House house;
}
