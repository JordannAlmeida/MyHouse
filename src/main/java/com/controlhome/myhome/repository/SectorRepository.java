package com.controlhome.myhome.repository;

import com.controlhome.myhome.entity.Sector;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SectorRepository extends CrudRepository<Sector, Integer> {
    List<Sector> findByIdIn(List<Integer> ids);
}
