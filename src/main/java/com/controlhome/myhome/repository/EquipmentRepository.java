package com.controlhome.myhome.repository;

import com.controlhome.myhome.entity.Equipment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EquipmentRepository extends CrudRepository<Equipment, Integer> {
    List<Equipment> findByIdIn(List<Integer> ids);
}
