package com.kubertX.austinX.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/halo")
public class HaloController {

    @GetMapping("halo")
    public String halo(){
        return "halo austinX";
    }
}
