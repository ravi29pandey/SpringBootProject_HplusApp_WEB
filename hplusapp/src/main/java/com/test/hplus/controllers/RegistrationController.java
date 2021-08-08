package com.test.hplus.controllers;


import com.test.hplus.beans.User;
import com.test.hplus.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class RegistrationController {

    @Autowired
    private UserRepository userRepository;


    @InitBinder /*custom   */
    public void initBinder(WebDataBinder binder){
        binder.registerCustomEditor(Date.class, "dateOfBirth" ,new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"),true));
    }

    @PostMapping("/registeruser")
    public String registrationUser(@Valid @ModelAttribute("newuser")User user, BindingResult result, Model model){
      /*@valid is for data validation before it performs auto binding using @ModelAttribute and follows to this
      * BindingResult to be added so as ,if any validation fails
      *  then this bindingResult populate an error message*/
      System.out.println(user.getDateOfBirth());
        if(result.hasErrors()){

            return "register";
        }


       userRepository.save(user);
       model.addAttribute("dataSaved","User registration successful");
        return "login";
    }
    }




