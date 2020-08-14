package com.muffinbackendjavaheejin.web.Test;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/")
    public String helloWorld(){
        return "TDD Success !!";
    }

}
