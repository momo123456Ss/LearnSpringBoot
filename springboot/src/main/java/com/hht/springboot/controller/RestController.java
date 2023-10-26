/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hht.springboot.controller;

import com.hht.springboot.pojo.User;
import com.hht.springboot.service.UserService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author HOME
 */
@org.springframework.web.bind.annotation.RestController
@RequestMapping("/api")
public class RestController {
    @Autowired
    private UserService userService;


    @RequestMapping("/findAllUser/")
    @CrossOrigin
    public ResponseEntity<List<User>> findAllUser() {
        return new ResponseEntity<>(this.userService.getAllUsers(), HttpStatus.OK);
    }
    @RequestMapping("/findAllUserSecond/")
    @CrossOrigin
    public ResponseEntity<List<User>> findAllUserSecond(Map<String, String> params) {
        return new ResponseEntity<>(this.userService.getAllUserSecond(params), HttpStatus.OK);
    }
}
