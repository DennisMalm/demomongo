package com.example.demomongo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MongoController {

    @RequestMapping("/hello")
    public String getHello(){
        return "Hej hej";
    }



}
