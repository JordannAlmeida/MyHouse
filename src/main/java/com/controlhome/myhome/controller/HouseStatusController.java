package com.controlhome.myhome.controller;

import com.controlhome.myhome.exception.CustomErrorException;
import com.controlhome.myhome.model.DefaultResponse;
import com.controlhome.myhome.model.houseSratus.HouseStatusBySector;
import com.controlhome.myhome.service.HouseStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping(value = "/api/status")
public class HouseStatusController {

        @Autowired
        private HouseStatusService houseStatusService;

        @GetMapping(value = "/get-all-equipments-on")
        public ResponseEntity<DefaultResponse<List<HouseStatusBySector>>> getAllEquipmentsOn() {
            try {
                List<HouseStatusBySector> listHouseStatusBySector = houseStatusService.getAllEquipmentsOn();
                return ResponseEntity.ok().body(DefaultResponse.<List<HouseStatusBySector>>builder().sucess(true).content(listHouseStatusBySector).build());
            }
            catch (CustomErrorException c) {
                return ResponseEntity.status(c.getHttpStatus()).body(DefaultResponse.<List<HouseStatusBySector>>builder().sucess(false).message(c.getMessage()).build());
            }
            catch(Exception e) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(DefaultResponse.<List<HouseStatusBySector>>builder().sucess(false).message("Ocorreu uma falha ao obter a lista de equipamentos, tente novamente").build());
            }
        }

    @GetMapping(value = "/get-all-equipments-off")
    public ResponseEntity<DefaultResponse<List<HouseStatusBySector>>> getAllEquipmentsOff() {
        try {
            List<HouseStatusBySector> listHouseStatusBySector = houseStatusService.getAllEquipmentsOff();
            return ResponseEntity.ok().body(DefaultResponse.<List<HouseStatusBySector>>builder().sucess(true).content(listHouseStatusBySector).build());
        }
        catch (CustomErrorException c) {
            return ResponseEntity.status(c.getHttpStatus()).body(DefaultResponse.<List<HouseStatusBySector>>builder().sucess(false).message(c.getMessage()).build());
        }
        catch(Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(DefaultResponse.<List<HouseStatusBySector>>builder().sucess(false).message("Ocorreu uma falha ao obter a lista de equipamentos, tente novamente").build());
        }
    }
}
