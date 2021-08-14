package com.test.hplus.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
/*Concept of redirect is to redirect to other website unlike in forwarding concept
* where it works within the same webpages itself
* */
@Controller
public class RedirectionController {

    @GetMapping("/redirectToLinkeidIn")

    public String redirectOut(){
        System.out.println("in redirect controller");

        return "redirect:http://www.linkedin.com";


    }
}
