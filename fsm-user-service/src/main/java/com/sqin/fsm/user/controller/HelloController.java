package com.sqin.fsm.user.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author: Mr. Qin
 * Created: 2025-07-31 22:55
 */
@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello, FSM family!";
    }

}
