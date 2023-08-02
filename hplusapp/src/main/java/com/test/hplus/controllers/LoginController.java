package com.test.hplus.controllers;


import com.test.hplus.beans.Login;
import com.test.hplus.beans.User;
import com.test.hplus.exception.ApplicationException;
import com.test.hplus.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpSession;

@Controller
@SessionAttributes("login") /* Saving data in session with name login ,make sure
 @ModelAttribute also do have the same name as of @SessionAttributes and it is to be
instanciated in a advice that is in DefaultModelAttributeController
this login stores the data in SessionAttributes throughout the session */
public class LoginController {

    @Autowired
    private UserRepository userRepository;
    @PostMapping("/login")
     public String login(@ModelAttribute("login")Login login , HttpSession session){
        //fullsessionmanagemnet
        //with session object
        //session.setAttribute("","")
        //session.setMaxInactiveInterval(50000);this make session time for website (TimeOut)

      User user=userRepository.searchByName(login.getUsername());
      if(user==null){
          throw new ApplicationException("User not found");
      }
      return  "forward:/userprofile";
      /*this is concept of forwarding where return to other mapping where
      * already the landing page is defined under session */
    }

    @ExceptionHandler(ApplicationException.class)  //*telling exceptionHandler to handle which class*//*
    public String handleException(){
       System.out.println("in exception handler of login Controller");
       return "error";  //Show ViewName
    }

}
