package com.controlhome.myhome.repository;

import com.controlhome.myhome.entity.House;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HouseRepository extends CrudRepository<House, Integer> {
    House findByHouseName(String houseName);
}
