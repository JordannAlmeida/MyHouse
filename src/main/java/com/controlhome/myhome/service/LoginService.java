package com.controlhome.myhome.service;

import org.springframework.stereotype.Service;

@Service
public interface LoginService {
    void doLogin(String username, String pass) throws Exception;

    void createLogin(String username, String pass) throws Exception;
}
