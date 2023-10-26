/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.hht.springboot.service;

import com.hht.springboot.pojo.Roleuser;
import java.util.List;

/**
 *
 * @author HOME
 */
public interface RoleService {
    List<Roleuser> getRole();

    Roleuser getRoleUserById(int id);
}
