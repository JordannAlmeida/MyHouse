package com.controlhome.myhome.service;

import com.controlhome.myhome.entity.User;
import com.controlhome.myhome.exception.CustomErrorException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import com.controlhome.myhome.repository.UserRepository;
import com.controlhome.myhome.util.Criptografia;

import java.util.Date;

@Service
public class LoginServiceImpl implements LoginService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public void doLogin(String username, String pass) throws Exception {
        User user = userRepository.findByUserLogin(username);
        if (user == null) {
            new CustomErrorException(HttpStatus.BAD_REQUEST, "Usuário ou senha incorretos");
        }
        String passRecovery = user.getPass();
        Criptografia criptografia = new Criptografia();
        passRecovery = criptografia.decrypt(passRecovery);
        if(!passRecovery.equals(pass)) {
            new CustomErrorException(HttpStatus.BAD_REQUEST, "Usuário ou senha incorretos");
        }
    }

    @Override
    public void createLogin(String username, String pass) throws Exception {
        User user = userRepository.findByUserLogin(username);
        if (user != null) {
            new CustomErrorException(HttpStatus.BAD_REQUEST, "Nome já utilizado, escolha outro");
        }
        Criptografia criptografia = new Criptografia();
        String passRecovery = criptografia.encrypt(pass);
        user = new User();
        user.setUserLogin(username);
        user.setPass(passRecovery);
        user.setDateCreated(new Date());
        userRepository.save(user);
    }

}
