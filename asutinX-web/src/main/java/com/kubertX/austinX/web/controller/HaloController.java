package com.kubertX.austinX.web.controller;

import com.kubertX.austinX.common.domain.MessageTemplate;
import com.kubertX.austinX.web.service.HaloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/halo")
public class HaloController {

    @Autowired
    private HaloService haloService;

    @GetMapping("halo")
    public String halo(){
        return "halo austinX";
    }

    @GetMapping("get")
    public MessageTemplate get(){
        return haloService.get();
    }
}
