package com.fierew.adminxcontroller.controller;

import com.fierew.adminxservice.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IntexController {
    @Autowired
    private IndexService indexService;

    @GetMapping("/")
    String index() {
        indexService.index("xuyang");
        return "Hello World!";
    }
}
