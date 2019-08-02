package com.controlhome.myhome.service;

import com.controlhome.myhome.entity.House;
import com.controlhome.myhome.entity.User;
import com.controlhome.myhome.repository.HouseRepository;
import com.controlhome.myhome.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HouseServiceImpl implements HouseService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private HouseRepository houseRepository;

    @Override
    public House linkHouseUser(String houseName, String username) {
        User user = userRepository.findByUserLogin(username);
        String houseNameCode = houseName + " - " + user.getUserLogin();
        House house = houseRepository.findByHouseName(houseNameCode);
        if (house == null) {
            house = new House();
            house.setHouseName(houseNameCode);
        }
        house.setUser(user);
        return houseRepository.save(house);
    }
}
