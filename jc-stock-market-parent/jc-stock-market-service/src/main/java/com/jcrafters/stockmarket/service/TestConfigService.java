package com.jcrafters.stockmarket.service;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Service
@RefreshScope
@RequestMapping("api/stock")
public class TestConfigService {

    @Value("${additional.property.test}")
    private String testValue;


    @Value("${additional.property.test2}")
    private String testValue2;

    @GetMapping("test/config")
    public String testConfigValue() {
        return testValue;
    }

    @GetMapping("test/config2")
    public String testConfigValue2() {
        return testValue2;
    }




}
