package com.controlhome.myhome.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "equipment")
@Data
public class Equipment {

    @Id
    @Column(name = "equipment_id")
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    @Column(name = "name_equipment")
    private String nameEquipment;
}
