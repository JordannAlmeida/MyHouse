package controler;

import exception.CustomErrorException;
import lombok.extern.log4j.Log4j2;
import model.DefaultResponse;
import model.login.LoginRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import util.StringUtil;

@RestController
@Log4j2
public class LoginController {

    @Autowired


    @PostMapping("/login")
    public ResponseEntity doLogin(@RequestBody LoginRequest loginRequest){
        try {
            if (StringUtil.isValid(loginRequest.getUsername()) && StringUtil.isValid(loginRequest.getPassword())) {

            }
            return ResponseEntity.badRequest().body(DefaultResponse.builder().sucess(false).message("Dados incompletos").build());
        }
        catch (CustomErrorException c) {
            return ResponseEntity.status(c.getHttpStatus()).body(DefaultResponse.builder().sucess(false).message(c.getMessage()));
        }
        catch(Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(DefaultResponse.builder().sucess(false).message("Ocorreu uma falha ao logar, tente novamente").build());
        }
    }

}
