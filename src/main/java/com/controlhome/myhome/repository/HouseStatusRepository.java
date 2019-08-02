package com.controlhome.myhome.repository;

import com.controlhome.myhome.entity.HouseStatus;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HouseStatusRepository extends CrudRepository<HouseStatus, Integer> {
    List<HouseStatus> findByStatusEquipment(Integer status);
}
