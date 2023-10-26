/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hht.springboot.service.Impl;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.hht.springboot.pojo.Roleuser;
import com.hht.springboot.pojo.User;
import com.hht.springboot.repository.UserRepository;
import com.hht.springboot.service.RoleService;
import com.hht.springboot.service.UserService;
import com.hht.springboot.staticattribute.StaticSession;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.Order;
import jakarta.persistence.criteria.Root;
import java.util.ArrayList;

import java.util.List;
import java.util.Map;
import jakarta.persistence.criteria.Predicate;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author HOME
 */
@Service
@PropertySource("classpath:configs.properties")
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EntityManager entityManager;
    @Autowired
    private Environment env;

    @Autowired
    private Cloudinary cloudinary;
//    @Autowired
//    private BCryptPasswordEncoder passEncoder;

    @Autowired
    private RoleService roleService;
    @Autowired
    private SimpleDateFormat f;

    @Override
    public List<User> getAllUsers() {
        return this.userRepository.findAll();
    }

    @Override
    public User saveUser(User user) {
        return this.userRepository.save(user);
    }

    @Override
    public User getUserById(Integer id) {
        return this.userRepository.findById(id).get();
    }

    @Override
    public User updateUser(User user) {
        return this.userRepository.save(user);
    }

    @Override
    public void deleteUserById(Integer id) {
        this.userRepository.deleteById(id);

    }

    @Override
    public List<User> getAllUserSecond(Map<String, String> params) {
        CriteriaBuilder criteriaBuilder = this.entityManager.getCriteriaBuilder();
        CriteriaQuery<User> criteriaQuery = criteriaBuilder.createQuery(User.class);
        Root<User> root = criteriaQuery.from(User.class);
        criteriaQuery.select(root);

        if (params != null) {
            List<Predicate> predicates = new ArrayList<>();
            String login = params.get("Username");
            if (login != null && !login.isEmpty()) {
                predicates.add(criteriaBuilder.equal(root.get("username"), login));
            }
            String roleId = params.get("roleUser");
            if (roleId != null && !roleId.isEmpty()) {
                // Tạo join từ người dùng đến vai trò
                Join<User, Roleuser> roleJoin = root.join("fkuserRoleuserId"); // Thay "userRole" bằng tên thực tế của mối quan hệ

                // So sánh vai trò
                predicates.add(criteriaBuilder.equal(roleJoin.get("id"), Integer.parseInt(roleId)));

//                predicates.add(criteriaBuilder.equal(root.get("fkuserRoleuserId"), Integer.parseInt(roleId)));
            }

            criteriaQuery.where(predicates.toArray(Predicate[]::new));

        }

        Order order = criteriaBuilder.desc(root.get("id"));
        criteriaQuery.orderBy(order);

        Query query = this.entityManager.createQuery(criteriaQuery);
        if (params != null) {
            String page = params.get("page");
            if (page != null && !page.isEmpty()) {
                int p = Integer.parseInt(page);
                int pageSize = Integer.parseInt(this.env.getProperty("PAGE_SIZE"));

                query.setMaxResults(pageSize);
                query.setFirstResult((p - 1) * pageSize);
            }
        }
        return query.getResultList();
    }

    @Override
    public Long countUser() {
        Query query = entityManager.createQuery("SELECT Count(*) FROM User");
        Long count = (Long) query.getSingleResult();
        return count;
    }

    @Override
    public boolean addOrUpdateUser(User user) {
        try {
            if (user.getId() == null) {
                if (checkUserName(user.getUsername())) {
                    StaticSession.msgError = "Username exists";
                    return false;
                } else {
                    if (user.getFile() != null && !user.getFile().isEmpty()) {
                        try {
                            Map res = this.cloudinary.uploader().upload(user.getFile().getBytes(), ObjectUtils.asMap("resource_type", "auto"));
                            user.setImage(res.get("secure_url").toString());
                        } catch (IOException ex) {
                            Logger.getLogger(UserServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
                            return false;
                        }
                    } else {
                        StaticSession.msgError = "Must have Avatar";
                        return false;
                    }
                    user.setCreatedDate(f.format(new Date()));
                    user.setFkuserRoleuserId(this.roleService.getRoleUserById(3));
//                    user.setPassword(this.passEncoder.encode(user.getPassword()));
                    StaticSession.msgError = "";
                    this.userRepository.save(user);
                }
            } else {
                if (user.getFile() != null && !user.getFile().isEmpty()) {
                    try {
                        Map res = this.cloudinary.uploader().upload(user.getFile().getBytes(), ObjectUtils.asMap("resource_type", "auto"));
                        user.setImage(res.get("secure_url").toString());
                    } catch (IOException ex) {
                        Logger.getLogger(UserServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
                        return false;
                    }
                }
                this.userRepository.save(user);
            }
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean checkUserName(String username) {
        Query q = this.entityManager.createQuery("SELECT Count(*) FROM User WHERE username=:un");
        q.setParameter("un", username);

        if (Integer.parseInt(q.getSingleResult().toString()) >= 1) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User u = getUserByUsername(username);
        if (u == null) {
            throw new UsernameNotFoundException("Invalid");
        }
        Set<GrantedAuthority> authorities = new HashSet<>();
        authorities.add(new SimpleGrantedAuthority(u.getFkuserRoleuserId().getName()));
         org.springframework.security.core.userdetails.User p  = new org.springframework.security.core.userdetails.User( u.getUsername(), u.getPassword(), authorities);
        return new org.springframework.security.core.userdetails.User(
                u.getUsername(), u.getPassword(), authorities);
    }

    @Override
    public User getUserByUsername(String username) {

        Query q = this.entityManager.createQuery("FROM User WHERE username=:un");
        q.setParameter("un", username);
        return (User) q.getSingleResult();
    }

}
