/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hht.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author HOME
 */
@Controller
public class PublicController {

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/access-denied")
    public String accessDenied() {
        return "exception/access-denied";
    }
}
