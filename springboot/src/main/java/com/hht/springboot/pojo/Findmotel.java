/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hht.springboot.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
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
@Table(name = "findmotel")
@NamedQueries({
    @NamedQuery(name = "Findmotel.findAll", query = "SELECT f FROM Findmotel f"),
    @NamedQuery(name = "Findmotel.findById", query = "SELECT f FROM Findmotel f WHERE f.id = :id"),
    @NamedQuery(name = "Findmotel.findByDetaileddescription", query = "SELECT f FROM Findmotel f WHERE f.detaileddescription = :detaileddescription"),
    @NamedQuery(name = "Findmotel.findByCity", query = "SELECT f FROM Findmotel f WHERE f.city = :city"),
    @NamedQuery(name = "Findmotel.findByDistrict", query = "SELECT f FROM Findmotel f WHERE f.district = :district"),
    @NamedQuery(name = "Findmotel.findByCreatedDate", query = "SELECT f FROM Findmotel f WHERE f.createdDate = :createdDate")})
public class Findmotel implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "detaileddescription")
    private String detaileddescription;
    @Lob
    @Column(name = "map")
    private String map;
    @Column(name = "city")
    private String city;
    @Column(name = "district")
    private String district;
    @Column(name = "created_date")
    private String createdDate;
    @OneToMany(mappedBy = "fkfindmotelFindmotelId")
    @JsonIgnore
    private Set<Findmotel> findmotelSet;
    @JoinColumn(name = "fkfindmotel_findmotel_id", referencedColumnName = "id")
    @ManyToOne
    private Findmotel fkfindmotelFindmotelId;
    @OneToMany(mappedBy = "fkfindmotelFindmotelIdReply")
    @JsonIgnore
    private Set<Findmotel> findmotelSet1;
    @JoinColumn(name = "fkfindmotel_findmotel_id_reply", referencedColumnName = "id")
    @ManyToOne
    private Findmotel fkfindmotelFindmotelIdReply;
    @JoinColumn(name = "fkfindmotel_user_id", referencedColumnName = "id")
    @ManyToOne
    private User fkfindmotelUserId;

    public Findmotel() {
    }

    public Findmotel(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDetaileddescription() {
        return detaileddescription;
    }

    public void setDetaileddescription(String detaileddescription) {
        this.detaileddescription = detaileddescription;
    }

    public String getMap() {
        return map;
    }

    public void setMap(String map) {
        this.map = map;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public Set<Findmotel> getFindmotelSet() {
        return findmotelSet;
    }

    public void setFindmotelSet(Set<Findmotel> findmotelSet) {
        this.findmotelSet = findmotelSet;
    }

    public Findmotel getFkfindmotelFindmotelId() {
        return fkfindmotelFindmotelId;
    }

    public void setFkfindmotelFindmotelId(Findmotel fkfindmotelFindmotelId) {
        this.fkfindmotelFindmotelId = fkfindmotelFindmotelId;
    }

    public Set<Findmotel> getFindmotelSet1() {
        return findmotelSet1;
    }

    public void setFindmotelSet1(Set<Findmotel> findmotelSet1) {
        this.findmotelSet1 = findmotelSet1;
    }

    public Findmotel getFkfindmotelFindmotelIdReply() {
        return fkfindmotelFindmotelIdReply;
    }

    public void setFkfindmotelFindmotelIdReply(Findmotel fkfindmotelFindmotelIdReply) {
        this.fkfindmotelFindmotelIdReply = fkfindmotelFindmotelIdReply;
    }

    public User getFkfindmotelUserId() {
        return fkfindmotelUserId;
    }

    public void setFkfindmotelUserId(User fkfindmotelUserId) {
        this.fkfindmotelUserId = fkfindmotelUserId;
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
        if (!(object instanceof Findmotel)) {
            return false;
        }
        Findmotel other = (Findmotel) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.hht.springboot.pojo.Findmotel[ id=" + id + " ]";
    }
    
}
