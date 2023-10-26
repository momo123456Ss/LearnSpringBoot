/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hht.springboot.formatters;

import com.hht.springboot.pojo.Roleuser;
import com.hht.springboot.repository.RoleRepository;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

/**
 *
 * @author HOME
 */
@Component
public class RoleUserFormatter implements Formatter<Roleuser> {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public Roleuser parse(String text, Locale locale) throws ParseException {
        Integer roleId = Integer.parseInt(text);
        return roleRepository.findById(roleId).orElse(null);
    }

    @Override
    public String print(Roleuser role, Locale locale) {
        return (role != null) ? role.getId().toString() : "";
    }
}
