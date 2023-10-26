/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hht.springboot.configs;

import java.text.SimpleDateFormat;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author HOME
 */
@Configuration
public class SimpleDateFormatConfig {
    @Bean
    public SimpleDateFormat simpleDateFormat() {
        return new SimpleDateFormat("yyyy-MM-dd"); // Thay đổi định dạng theo ý muốn
    }
}
