package com.controlhome.myhome.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "sector")
@Data
public class Sector {

    @Id
    @Column(name = "sector_id")
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    @Column(name = "name_sector")
    private String nameSector;
}
