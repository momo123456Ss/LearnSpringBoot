/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hht.springboot.controller;

import com.hht.springboot.service.UserService;
import java.security.Principal;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author HOME
 */
@Controller
@ControllerAdvice
public class IndexController {
    @Autowired
    private UserService userService;
        
    @ModelAttribute
    public void commonAttr(Model model, Principal u) {
        if (u != null) {
            model.addAttribute("principalInfo", this.userService.getUserByUsername(u.getName()));
        }

    }
    
    @GetMapping("/home")
    public String index(Model model, @RequestParam Map<String, String> params) {
        return "home";
    }
     @GetMapping("/")
    public String index2(Model model, @RequestParam Map<String, String> params) {
        return "home";
    }
}
