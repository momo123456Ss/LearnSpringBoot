/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hht.springboot.controller;

import com.hht.springboot.pojo.User;
import com.hht.springboot.service.RoleService;
import com.hht.springboot.service.UserService;
import com.hht.springboot.staticattribute.StaticSession;
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
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping("/update/{id}")
    public String update(Model model, @PathVariable(value = "id") int id) {
        model.addAttribute("userRole", this.roleService.getRole());
        model.addAttribute("user", this.userService.getUserById(id));
        return "admin/register";
    }

    @GetMapping("/update/password/user/{id}")
    public String updatePassword(Model model, @PathVariable(value = "id") int id) {
        model.addAttribute("user", this.userService.getUserById(id));
        return "admin/changepassword";
    }

    @PostMapping("/update/password")
    public String changePassword(@ModelAttribute(value = "user") @Valid User user, Model model,
            BindingResult rs) {
        if (!rs.hasErrors()) {
            if (userService.changePassword(user) == true) {
                return "redirect:/admin/index/User/";
            } else {
                model.addAttribute("msgErrShow", StaticSession.msgError);
                return "admin/changepassword";
            }
        }
        return "admin/changepassword";
    }

    @PostMapping("/register")
    public String addOrUpdate(@ModelAttribute(value = "user") @Valid User user, Model model,
            BindingResult rs) {
        if (!rs.hasErrors()) {
            if (userService.addOrUpdateUser(user) == true) {
                return "redirect:/admin/index/User/";
            } else {
                model.addAttribute("msgErrShow", StaticSession.msgError);
                return "admin/register";
            }
        }
        return "admin/register";
    }
}
