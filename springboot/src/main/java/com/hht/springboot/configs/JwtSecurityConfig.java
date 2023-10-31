/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hht.springboot.configs;

import com.hht.springboot.filters.CustomAccessDeniedHandler;
import com.hht.springboot.filters.JwtAuthenticationTokenFilter;
import com.hht.springboot.filters.RestAuthenticationEntryPoint;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 *
 * @author HOME
 */
@Configuration
@EnableTransactionManagement
@EnableWebSecurity
@Order(1)

public class JwtSecurityConfig {

    @Bean
    public JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter = new JwtAuthenticationTokenFilter();
        jwtAuthenticationTokenFilter.setAuthenticationManager(authenticationManager(authenticationConfiguration));

        return jwtAuthenticationTokenFilter;
    }

    @Bean
    public RestAuthenticationEntryPoint restServicesEntryPoint() {
        return new RestAuthenticationEntryPoint();
    }

    @Bean
    public CustomAccessDeniedHandler customAccessDeniedHandler() {
        return new CustomAccessDeniedHandler();
    }

    @Bean
    protected AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration)
            throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    protected SecurityFilterChain JwtSecurityConfig(HttpSecurity http, AuthenticationConfiguration authenticationConfiguration) throws Exception {
        http
                .formLogin(formLogin -> formLogin
                .loginPage("/login").permitAll()
                .usernameParameter("username")
                .passwordParameter("password")
                .defaultSuccessUrl("/home")
                .failureUrl("/login?error"))
                .exceptionHandling(exceptionHandling -> exceptionHandling
                .accessDeniedPage("/access-denied"))
                .logout(logout -> logout
                .logoutSuccessUrl("/login"));
        
        http
                .csrf(csrf -> csrf.ignoringRequestMatchers("/api/**"))
                .authorizeHttpRequests(auth -> auth
                //API    Front-end
                .requestMatchers("/api/current-user/").permitAll()
                .requestMatchers("/api/users/").permitAll()
                .requestMatchers("/api/login/").permitAll()
                .requestMatchers("/api/findAllUser/").hasRole("ADMIN")
                .requestMatchers("/api/findAllUserSecond/").hasRole("HOST")
                .requestMatchers(HttpMethod.GET, "/api/**").hasAnyRole("ADMIN", "HOST", "RENTER")
                .requestMatchers(HttpMethod.POST, "/api/**").hasAnyRole("ADMIN", "HOST")
                .requestMatchers(HttpMethod.DELETE, "/api/**").hasAnyRole("ADMIN", "HOST")
                );
        http
                .httpBasic(httpBasicConfigurer -> httpBasicConfigurer
                .authenticationEntryPoint(restServicesEntryPoint()))
//                .sessionManagement(sess -> sess.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .addFilterBefore(jwtAuthenticationTokenFilter(authenticationConfiguration),
                        UsernamePasswordAuthenticationFilter.class)
                .exceptionHandling(exceptionHandling -> exceptionHandling
                .accessDeniedHandler(customAccessDeniedHandler())
                );

        
        http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                .requestMatchers("/").permitAll()
                .requestMatchers("/home").permitAll()
                .requestMatchers("/css/**").permitAll()
                .requestMatchers("/js/**").permitAll()
                .requestMatchers("/h2-console/**").permitAll()
                .requestMatchers("/admin/**").hasRole("ADMIN")
                .anyRequest().authenticated()
                );

        return http.build();
    }

}
