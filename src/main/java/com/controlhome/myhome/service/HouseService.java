package com.controlhome.myhome.service;

import com.controlhome.myhome.entity.House;
import org.springframework.stereotype.Service;

@Service
public interface HouseService {
    House linkHouseUser(String house, String username);
}
