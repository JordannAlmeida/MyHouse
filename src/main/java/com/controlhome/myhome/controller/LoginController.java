package com.controlhome.myhome.controller;

import com.controlhome.myhome.exception.CustomErrorException;
import com.controlhome.myhome.model.DefaultResponse;
import com.controlhome.myhome.model.login.LoginRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.controlhome.myhome.service.LoginService;
import com.controlhome.myhome.util.StringUtil;

@RestController
@RequestMapping(value = "/api")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping(value = "/login")
    public ResponseEntity<DefaultResponse> doLogin(@RequestBody LoginRequest loginRequest){
        try {
            if (StringUtil.isValid(loginRequest.getUsername()) && StringUtil.isValid(loginRequest.getPassword())) {
                loginService.doLogin(loginRequest.getUsername(), loginRequest.getPassword());
                return ResponseEntity.ok().body(DefaultResponse.builder().sucess(true).message("Login realizado com sucesso").build());
            }
            return ResponseEntity.badRequest().body(DefaultResponse.builder().sucess(false).message("Dados incompletos").build());
        }
        catch (CustomErrorException c) {
            return ResponseEntity.status(c.getHttpStatus()).body(DefaultResponse.builder().sucess(false).message(c.getMessage()).build());
        }
        catch(Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(DefaultResponse.builder().sucess(false).message("Ocorreu uma falha ao logar, tente novamente").build());
        }
    }

    @RequestMapping(value = "/cadastrar")
    public ResponseEntity createLogin(@RequestBody LoginRequest loginRequest){
        try {
            if (StringUtil.isValid(loginRequest.getUsername()) && StringUtil.isValid(loginRequest.getPassword())) {
                loginService.createLogin(loginRequest.getUsername(), loginRequest.getPassword());
                return ResponseEntity.ok().body(DefaultResponse.builder().sucess(true).message("Cadastro realizado com sucesso").build());
            }
            return ResponseEntity.badRequest().body(DefaultResponse.builder().sucess(false).message("Dados incompletos").build());
        }
        catch (CustomErrorException c) {
            return ResponseEntity.status(c.getHttpStatus()).body(DefaultResponse.builder().sucess(false).message(c.getMessage()));
        }
        catch(Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(DefaultResponse.builder().sucess(false).message("Ocorreu uma falha ao cadastrar, tente novamente").build());
        }
    }

}
