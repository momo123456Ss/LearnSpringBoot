/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hht.springboot.controller;

import com.hht.springboot.pojo.User;
import com.hht.springboot.service.RoleService;
import com.hht.springboot.service.UserService;
import jakarta.validation.Valid;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author HOME
 */
@Controller
@RequestMapping("/admin")
@PropertySource("classpath:configs.properties")
public class AdminController {
    @Autowired
    private Environment env;
    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;
    @GetMapping("/index/User/")
    public String listUser(Model model, @RequestParam Map<String, String> params) {
        model.addAttribute("roleList", this.roleService.getRole());
        model.addAttribute("listUsers", this.userService.getAllUserSecond(params));
        int pageSize = Integer.parseInt(this.env.getProperty("PAGE_SIZE"));
        long count = this.userService.countUser();
        model.addAttribute("counter", Math.ceil(count * 1.0 / pageSize));

        return "indexuser";
    }
    
    @GetMapping("/register/new")
    public String register(Model model, @RequestParam Map<String, String> params) {
         model.addAttribute("user", new User());
        return "admin/register";
    }
    
    @PostMapping("/register")
    public String add(@ModelAttribute(value = "user") @Valid User user,Model model,
            BindingResult rs) {
        if (!rs.hasErrors()) {
            if (userService.addOrUpdateUser(user) == true) {
                return "redirect:/admin/index/User/";
            } else {
                return "admin/register";
            }
        }
        return "admin/register";
    }
}
