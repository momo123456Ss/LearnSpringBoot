/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.hht.springboot.service;

import com.hht.springboot.pojo.User;
import java.util.List;
import java.util.Map;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 *
 * @author HOME
 */
public interface UserService extends UserDetailsService {

    List<User> getAllUserSecond(Map<String, String> params);

    Long countUser();

    boolean addOrUpdateUser(User user);

    boolean checkUserName(String username);

    User getUserByUsername(String username);
    
    boolean changePassword(User user);
    boolean authUser(String username, String password);
    List<User> getAllUsers();

    User saveUser(User user);

    User getUserById(Integer id);

    User updateUser(User user);

    void deleteUserById(Integer id);

}
