package com.esi.esicommunication;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommunicationController {
    @GetMapping("/communication")
    public String helloWorld(){
        return "Welcome to the ESI course, communication!";
    }

}
