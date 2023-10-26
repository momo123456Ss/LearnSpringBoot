/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hht.springboot.pojo;

import java.io.Serializable;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;

/**
 *
 * @author HOME
 */
@Entity
@Table(name = "follower")
@NamedQueries({
    @NamedQuery(name = "Follower.findAll", query = "SELECT f FROM Follower f"),
    @NamedQuery(name = "Follower.findById", query = "SELECT f FROM Follower f WHERE f.id = :id")})
public class Follower implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "fkfollower_user_host_id", referencedColumnName = "id")
    @ManyToOne
    private User fkfollowerUserHostId;
    @JoinColumn(name = "fkfollower_user_renter_id", referencedColumnName = "id")
    @ManyToOne
    private User fkfollowerUserRenterId;

    public Follower() {
    }

    public Follower(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getFkfollowerUserHostId() {
        return fkfollowerUserHostId;
    }

    public void setFkfollowerUserHostId(User fkfollowerUserHostId) {
        this.fkfollowerUserHostId = fkfollowerUserHostId;
    }

    public User getFkfollowerUserRenterId() {
        return fkfollowerUserRenterId;
    }

    public void setFkfollowerUserRenterId(User fkfollowerUserRenterId) {
        this.fkfollowerUserRenterId = fkfollowerUserRenterId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Follower)) {
            return false;
        }
        Follower other = (Follower) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.hht.springboot.pojo.Follower[ id=" + id + " ]";
    }
    
}
