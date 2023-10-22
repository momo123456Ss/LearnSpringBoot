/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hht.springboot.controller;

import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author HOME
 */
@Controller
public class IndexController {
    @GetMapping("/test1/")
    public String index(Model model, @RequestParam Map<String, String> params) {
        return "home";
    }
     @GetMapping("/test2/")
    public String index2(Model model, @RequestParam Map<String, String> params) {
        return "home2";
    }
}
