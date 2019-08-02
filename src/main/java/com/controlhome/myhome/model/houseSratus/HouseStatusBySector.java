package com.controlhome.myhome.model.houseSratus;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class HouseStatusBySector {

    @JsonProperty("sectorName")
    private String sectorName;

    @JsonProperty("listEquipments")
    private List<String> listEquipments;

    public String getSectorName() {
        return sectorName;
    }

    public void setSectorName(String sectorName) {
        this.sectorName = sectorName;
    }

    public List<String> getListEquipments() {
        return listEquipments;
    }

    public void setListEquipments(List<String> listEquipments) {
        this.listEquipments = listEquipments;
    }
}
