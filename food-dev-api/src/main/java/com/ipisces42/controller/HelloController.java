package com.ipisces42.controller;

import io.swagger.v3.oas.annotations.Hidden;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author fuhaixin
 * @date 2022/8/16
 **/
@Slf4j
@Hidden
@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        log.info("hello");
        log.debug("hello");
        log.error("hello");
        log.warn("hello");
        return "Hello World";
    }
}
