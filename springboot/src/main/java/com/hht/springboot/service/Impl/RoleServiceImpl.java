/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hht.springboot.service.Impl;

import com.hht.springboot.pojo.Roleuser;
import com.hht.springboot.repository.RoleRepository;
import com.hht.springboot.service.RoleService;
import jakarta.persistence.EntityManager;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author HOME
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Roleuser> getRole() {
        return this.roleRepository.findAll();
    }

    @Override
    public Roleuser getRoleUserById(int id) {
        return entityManager.find(Roleuser.class, id);
    }

}
