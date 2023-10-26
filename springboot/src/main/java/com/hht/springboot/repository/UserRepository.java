/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.hht.springboot.repository;

import com.hht.springboot.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 *
 * @author HOME
 */
public interface UserRepository extends JpaRepository<User, Integer>{
}
