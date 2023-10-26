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
@Table(name = "motelimage")
@NamedQueries({
    @NamedQuery(name = "Motelimage.findAll", query = "SELECT m FROM Motelimage m"),
    @NamedQuery(name = "Motelimage.findById", query = "SELECT m FROM Motelimage m WHERE m.id = :id"),
    @NamedQuery(name = "Motelimage.findByImage", query = "SELECT m FROM Motelimage m WHERE m.image = :image")})
public class Motelimage implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "image")
    private String image;
    @JoinColumn(name = "fkmotelimage_motel_id", referencedColumnName = "id")
    @ManyToOne
    private Motel fkmotelimageMotelId;

    public Motelimage() {
    }

    public Motelimage(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Motel getFkmotelimageMotelId() {
        return fkmotelimageMotelId;
    }

    public void setFkmotelimageMotelId(Motel fkmotelimageMotelId) {
        this.fkmotelimageMotelId = fkmotelimageMotelId;
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
        if (!(object instanceof Motelimage)) {
            return false;
        }
        Motelimage other = (Motelimage) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.hht.springboot.pojo.Motelimage[ id=" + id + " ]";
    }
    
}
