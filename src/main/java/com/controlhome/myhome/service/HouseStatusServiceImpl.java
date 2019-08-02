package com.controlhome.myhome.service;

import com.controlhome.myhome.entity.Equipment;
import com.controlhome.myhome.entity.HouseStatus;
import com.controlhome.myhome.entity.Sector;
import com.controlhome.myhome.exception.CustomErrorException;
import com.controlhome.myhome.model.houseSratus.HouseStatusBySector;
import com.controlhome.myhome.repository.EquipmentRepository;
import com.controlhome.myhome.repository.HouseStatusRepository;
import com.controlhome.myhome.repository.SectorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HouseStatusServiceImpl implements HouseStatusService {

    @Autowired
    private HouseStatusRepository houseStatusRepository;

    @Autowired
    private SectorRepository sectorRepository;

    @Autowired
    private EquipmentRepository equipmentRepository;

    @Override
    public List<HouseStatusBySector> getAllEquipmentsOn() {
        List<HouseStatus> listHouseStatus = houseStatusRepository.findByStatusEquipment(1);
        if (listHouseStatus != null && listHouseStatus.size() > 0) {
            List<HouseStatusBySector> response = new ArrayList<>();
            int count = 0;
            List<Integer> auxSector = new ArrayList();
            for (HouseStatus houseStatus: listHouseStatus) {
                if(auxSector.size() > 0) {
                    for (int i = 0; i < auxSector.size(); i++) {
                        if(auxSector.get(i) != houseStatus.getSector().intValue()) {
                            count ++;
                            auxSector.add(houseStatus.getSector().intValue());
                        }
                    }
                } else {
                    auxSector.add(houseStatus.getSector().intValue());
                }
            }
            for (Integer i: auxSector) {
                Sector sector = sectorRepository.findById(i).get();
                List<String> equipments = new ArrayList<>();
                for (HouseStatus houseStatus : listHouseStatus) {
                    if (houseStatus.getSector().intValue() == i) {
                        Equipment equipment = equipmentRepository.findById(i).get();
                        equipments.add(equipment.getNameEquipment());
                    }
                }
                HouseStatusBySector houseStatusBySector = new HouseStatusBySector();
                houseStatusBySector.setSectorName(sector.getNameSector());
                houseStatusBySector.setListEquipments(equipments);
                response.add(houseStatusBySector);
            }
            return response;
        }
        throw CustomErrorException.builder().httpStatus(HttpStatus.OK).message("Não temos nenhum aparelho ligado no momento").build();
    }

    @Override
    public List<HouseStatusBySector> getAllEquipmentsOff() {
        List<HouseStatus> listHouseStatus = houseStatusRepository.findByStatusEquipment(0);
        if (listHouseStatus != null && listHouseStatus.size() > 0) {
            List<HouseStatusBySector> response = new ArrayList<>();
            int count = 0;
            List<Integer> auxSector = new ArrayList();
            for (HouseStatus houseStatus: listHouseStatus) {
                if(auxSector.size() > 0) {
                    for (int i = 0; i < auxSector.size(); i++) {
                        if(auxSector.get(i) != houseStatus.getSector().intValue()) {
                            count ++;
                            auxSector.add(houseStatus.getSector().intValue());
                        }
                    }
                } else {
                    auxSector.add(houseStatus.getSector().intValue());
                }
            }
            for (Integer i: auxSector) {
                Sector sector = sectorRepository.findById(i).get();
                List<String> equipments = new ArrayList<>();
                for (HouseStatus houseStatus : listHouseStatus) {
                    if (houseStatus.getSector().intValue() == i) {
                        Equipment equipment = equipmentRepository.findById(i).get();
                        equipments.add(equipment.getNameEquipment());
                    }
                }
                HouseStatusBySector houseStatusBySector = new HouseStatusBySector();
                houseStatusBySector.setSectorName(sector.getNameSector());
                houseStatusBySector.setListEquipments(equipments);
                response.add(houseStatusBySector);
            }
            return response;
        }
        throw CustomErrorException.builder().httpStatus(HttpStatus.OK).message("Não temos nenhum aparelho ligado no momento").build();
    }
}
