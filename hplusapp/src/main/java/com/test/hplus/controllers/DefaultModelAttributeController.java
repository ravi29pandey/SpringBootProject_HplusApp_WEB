package com.test.hplus.controllers;

import com.test.hplus.beans.Login;
import com.test.hplus.beans.User;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.Arrays;
import java.util.List;

@ControllerAdvice /*Simply writes piece of code globally*/
public class DefaultModelAttributeController {


    @ModelAttribute("newuser") /*Data Binding*/
    public User getDefaultUser(){
        return new User();
    }


    @ModelAttribute("genderItems") /*Data Binding*/
    public List<String> getGenderItems(){
        return Arrays.asList(new String[]{"Male","Female","Other"});
    }


    @ModelAttribute("login") /*Data Binding*/
    public Login getDefaultLogin(){
        return new Login();
    }

}
