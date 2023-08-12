package com.learning.socialmediaapi.controller;

import lombok.ToString;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;



record PersonV1(String name) {}
record PersonV2(String firstName, String lastName) {}

@RestController
public class VersioningPersonController {

@GetMapping("/v1/persion")
    public String getFirstVersionPerson(){
     return new PersonV1("Bob Marlay").toString();
}

    @GetMapping("/v2/persion")
    public String getSecondVersionPerson(){
        return new PersonV2("sarvesh", "reddy").toString();
    }
}
