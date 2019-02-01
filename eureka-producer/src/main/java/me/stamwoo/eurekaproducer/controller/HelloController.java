package me.stamwoo.eurekaproducer.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @author woo
 */
@RestController
@RequestMapping("/hello")
public class HelloController {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @GetMapping("/")
    public String hello(@RequestParam String name) {
        logger.info("lalallalalallalala");
        return "Hello, " + name + " " + new Date();
    }

}