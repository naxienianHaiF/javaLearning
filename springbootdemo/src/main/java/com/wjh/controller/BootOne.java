package com.wjh.controller;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by WJH on 2017年07月30日 19:31
 */

@RestController
@EnableAutoConfiguration
public class BootOne {

    @RequestMapping("/hello")
    public String hello(){
        return "hello,spring boot";
    }
}
