package me.stamwoo.eurekaconsumerfeignhystrix.controller;

import me.stamwoo.eurekaconsumerfeignhystrix.HelloRemote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author woo
 */
@RequestMapping("/hello")
@RestController
public class HelloController {

    @Autowired
    private HelloRemote helloRemote;

    @GetMapping("/{name}")
    public String index(@PathVariable("name") String name) {
        return helloRemote.hello(name + "!");
    }

}