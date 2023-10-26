///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
//package com.hht.springboot.repository.Impl;
//
//import com.hht.springboot.pojo.User;
//import com.hht.springboot.repository.UserRepository;
//import java.util.List;
//import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;
//import javax.persistence.criteria.CriteriaBuilder;
//import javax.persistence.criteria.CriteriaQuery;
//import javax.persistence.criteria.Root;
//import org.springframework.stereotype.Repository;
//import org.springframework.transaction.annotation.Transactional;
//
///**
// *
// * @author HOME
// */
//@Repository
//@Transactional
//public class UserRepositoryImpl implements UserRepository{
//    @PersistenceContext
//    private EntityManager entityManager;
//    @Override
//    public List<User> findAll() {
//        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
//        CriteriaQuery<User> criteriaQuery = criteriaBuilder.createQuery(User.class);
//        Root<User> root = criteriaQuery.from(User.class);
//
//        criteriaQuery.select(root);
//
//        return entityManager.createQuery(criteriaQuery).getResultList();
//    }
//
//    
//}
