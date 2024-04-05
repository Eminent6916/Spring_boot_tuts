package com.onspring6916.Spring_boot_tuts.Controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @Value("${welcome.message}")
    private String welcomeMessage;
//    @RequestMapping(value ="/", method = RequestMethod.GET)
    @GetMapping("/")
    public String helloWorld (){

        return welcomeMessage;
    }
}