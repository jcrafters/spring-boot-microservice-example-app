package com.jcrafters.stockmarket.service;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Service
@Transactional
public class TestRestService {

    @GetMapping("api/hello")
    public String getTestInfo() {
        return "Hello";
    }

}
