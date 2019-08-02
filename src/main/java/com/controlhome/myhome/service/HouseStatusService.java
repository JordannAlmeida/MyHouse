package com.controlhome.myhome.service;

import com.controlhome.myhome.model.houseSratus.HouseStatusBySector;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface HouseStatusService {
    List<HouseStatusBySector> getAllEquipmentsOn();

    List<HouseStatusBySector> getAllEquipmentsOff();
}
