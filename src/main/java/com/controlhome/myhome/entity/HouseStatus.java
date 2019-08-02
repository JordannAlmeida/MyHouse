package com.controlhome.myhome.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "house_status")
@Data
public class HouseStatus {

    @Id
    private Integer id;

    @Column(name = "house_id")
    private Integer house;

    @Column(name = "sector_id")
    private Integer sector;

    @Column(name = "equipment_id")
    private Integer equipment;

    @Column(name = "status_equipment")
    private Integer statusEquipment;

}
