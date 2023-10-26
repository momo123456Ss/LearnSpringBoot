/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hht.springboot.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.Set;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

/**
 *
 * @author HOME
 */
@Entity
@Table(name = "motel")
@NamedQueries({
    @NamedQuery(name = "Motel.findAll", query = "SELECT m FROM Motel m"),
    @NamedQuery(name = "Motel.findById", query = "SELECT m FROM Motel m WHERE m.id = :id"),
    @NamedQuery(name = "Motel.findByName", query = "SELECT m FROM Motel m WHERE m.name = :name"),
    @NamedQuery(name = "Motel.findByAddress", query = "SELECT m FROM Motel m WHERE m.address = :address"),
    @NamedQuery(name = "Motel.findByCityprovince", query = "SELECT m FROM Motel m WHERE m.cityprovince = :cityprovince"),
    @NamedQuery(name = "Motel.findByDistrict", query = "SELECT m FROM Motel m WHERE m.district = :district"),
    @NamedQuery(name = "Motel.findByPhone", query = "SELECT m FROM Motel m WHERE m.phone = :phone"),
    @NamedQuery(name = "Motel.findByNumberofresidents", query = "SELECT m FROM Motel m WHERE m.numberofresidents = :numberofresidents"),
    @NamedQuery(name = "Motel.findByPrice", query = "SELECT m FROM Motel m WHERE m.price = :price"),
    @NamedQuery(name = "Motel.findByTitle", query = "SELECT m FROM Motel m WHERE m.title = :title"),
    @NamedQuery(name = "Motel.findByDescription", query = "SELECT m FROM Motel m WHERE m.description = :description"),
    @NamedQuery(name = "Motel.findByAcreage", query = "SELECT m FROM Motel m WHERE m.acreage = :acreage"),
    @NamedQuery(name = "Motel.findByCreatedDate", query = "SELECT m FROM Motel m WHERE m.createdDate = :createdDate"),
    @NamedQuery(name = "Motel.findByApply", query = "SELECT m FROM Motel m WHERE m.apply = :apply")})
public class Motel implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "address")
    private String address;
    @Column(name = "cityprovince")
    private String cityprovince;
    @Column(name = "district")
    private String district;
    @Lob
    @Column(name = "map")
    private String map;
    @Column(name = "phone")
    private String phone;
    @Column(name = "numberofresidents")
    private Integer numberofresidents;
    @Column(name = "price")
    private BigInteger price;
    @Column(name = "title")
    private String title;
    @Column(name = "description")
    private String description;
    @Column(name = "acreage")
    private String acreage;
    @Column(name = "created_date")
    private String createdDate;
    @Column(name = "apply")
    private Boolean apply;
    @OneToMany(mappedBy = "fkmotelimageMotelId")
    @JsonIgnore
    private Set<Motelimage> motelimageSet;
    @OneToMany(mappedBy = "fkevaluteMotelId")
    @JsonIgnore
    private Set<Evaluate> evaluateSet;
    @JoinColumn(name = "fkmotel_user_id", referencedColumnName = "id")
    @ManyToOne
    private User fkmotelUserId;

    public Motel() {
    }

    public Motel(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCityprovince() {
        return cityprovince;
    }

    public void setCityprovince(String cityprovince) {
        this.cityprovince = cityprovince;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getMap() {
        return map;
    }

    public void setMap(String map) {
        this.map = map;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getNumberofresidents() {
        return numberofresidents;
    }

    public void setNumberofresidents(Integer numberofresidents) {
        this.numberofresidents = numberofresidents;
    }

    public BigInteger getPrice() {
        return price;
    }

    public void setPrice(BigInteger price) {
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAcreage() {
        return acreage;
    }

    public void setAcreage(String acreage) {
        this.acreage = acreage;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public Boolean getApply() {
        return apply;
    }

    public void setApply(Boolean apply) {
        this.apply = apply;
    }

    public Set<Motelimage> getMotelimageSet() {
        return motelimageSet;
    }

    public void setMotelimageSet(Set<Motelimage> motelimageSet) {
        this.motelimageSet = motelimageSet;
    }

    public Set<Evaluate> getEvaluateSet() {
        return evaluateSet;
    }

    public void setEvaluateSet(Set<Evaluate> evaluateSet) {
        this.evaluateSet = evaluateSet;
    }

    public User getFkmotelUserId() {
        return fkmotelUserId;
    }

    public void setFkmotelUserId(User fkmotelUserId) {
        this.fkmotelUserId = fkmotelUserId;
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
        if (!(object instanceof Motel)) {
            return false;
        }
        Motel other = (Motel) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.hht.springboot.pojo.Motel[ id=" + id + " ]";
    }
    
}
