package com.test.hplus.restcontrollers;


import com.test.hplus.beans.Login;
import com.test.hplus.beans.User;
import com.test.hplus.exception.LoginFailureException;
import com.test.hplus.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginRestController {


    @Autowired
    private UserRepository userRepository;


    @PostMapping("/hplus/rest/loginuser")

    public ResponseEntity loginuser(@RequestBody Login login) throws LoginFailureException {
        System.out.println(login.getUsername() + "" + login.getPassword());
        User user = userRepository.searchByName(login.getUsername());

        if (user == null) {
            return ResponseEntity.status(404).build();
        }

        if (user.getUsername().equals(login.getUsername()) &&
                user.getPassword().equals(login.getPassword())) {
            return new ResponseEntity<>("Welcome"+user.getUsername(), HttpStatus.OK);
        } else {
            //throw new Exception
            throw new LoginFailureException("Invalid Username OR Password");


        }


    }
}
