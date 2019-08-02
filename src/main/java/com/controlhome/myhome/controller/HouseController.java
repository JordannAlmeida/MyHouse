package com.controlhome.myhome.controller;

import com.controlhome.myhome.entity.House;
import com.controlhome.myhome.exception.CustomErrorException;
import com.controlhome.myhome.model.DefaultResponse;
import com.controlhome.myhome.model.house.LinkHouseUserRequst;
import com.controlhome.myhome.service.HouseService;
import com.controlhome.myhome.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/house")
public class HouseController {


    @Autowired
    private HouseService houseService;

    @PostMapping(value = "/link-house-user")
    public ResponseEntity<DefaultResponse<House>> linkHouseUser(@RequestBody LinkHouseUserRequst linkHouseUserRequst){
        try {
            if (StringUtil.isValid(linkHouseUserRequst.getUsername()) && StringUtil.isValid(linkHouseUserRequst.getHouse())) {
                House house = houseService.linkHouseUser(linkHouseUserRequst.getHouse(), linkHouseUserRequst.getUsername());
                return ResponseEntity.ok().body(DefaultResponse.<House>builder().sucess(true).message("Casa cadastrada com sucesso").content(house).build());
            }
            return ResponseEntity.badRequest().body(DefaultResponse.<House>builder().sucess(false).message("Dados incompletos").build());
        }
        catch (CustomErrorException c) {
            return ResponseEntity.status(c.getHttpStatus()).body(DefaultResponse.<House>builder().sucess(false).message(c.getMessage()).build());
        }
        catch(Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(DefaultResponse.<House>builder().sucess(false).message("Ocorreu uma falha ao cadastrar a sua casa, tente novamente").build());
        }
    }

}
