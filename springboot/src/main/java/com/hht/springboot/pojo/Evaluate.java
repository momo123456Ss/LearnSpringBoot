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
@Table(name = "evaluate")
@NamedQueries({
    @NamedQuery(name = "Evaluate.findAll", query = "SELECT e FROM Evaluate e"),
    @NamedQuery(name = "Evaluate.findById", query = "SELECT e FROM Evaluate e WHERE e.id = :id"),
    @NamedQuery(name = "Evaluate.findByComment", query = "SELECT e FROM Evaluate e WHERE e.comment = :comment"),
    @NamedQuery(name = "Evaluate.findByCreatedDate", query = "SELECT e FROM Evaluate e WHERE e.createdDate = :createdDate")})
public class Evaluate implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "comment")
    private String comment;
    @Column(name = "created_date")
    private String createdDate;
    @OneToMany(mappedBy = "fkevaluteEvaluateId")
    @JsonIgnore
    private Set<Evaluate> evaluateSet;
    @JoinColumn(name = "fkevalute_evaluate_id", referencedColumnName = "id")
    @ManyToOne
    private Evaluate fkevaluteEvaluateId;
    @OneToMany(mappedBy = "fkevaluteEvaluateIdReply")
    @JsonIgnore
    private Set<Evaluate> evaluateSet1;
    @JoinColumn(name = "fkevalute_evaluate_id_reply", referencedColumnName = "id")
    @ManyToOne
    private Evaluate fkevaluteEvaluateIdReply;
    @JoinColumn(name = "fkevalute_motel_id", referencedColumnName = "id")
    @ManyToOne
    private Motel fkevaluteMotelId;
    @JoinColumn(name = "fkevalute_user_id_respondent", referencedColumnName = "id")
    @ManyToOne
    private User fkevaluteUserIdRespondent;

    public Evaluate() {
    }

    public Evaluate(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public Set<Evaluate> getEvaluateSet() {
        return evaluateSet;
    }

    public void setEvaluateSet(Set<Evaluate> evaluateSet) {
        this.evaluateSet = evaluateSet;
    }

    public Evaluate getFkevaluteEvaluateId() {
        return fkevaluteEvaluateId;
    }

    public void setFkevaluteEvaluateId(Evaluate fkevaluteEvaluateId) {
        this.fkevaluteEvaluateId = fkevaluteEvaluateId;
    }

    public Set<Evaluate> getEvaluateSet1() {
        return evaluateSet1;
    }

    public void setEvaluateSet1(Set<Evaluate> evaluateSet1) {
        this.evaluateSet1 = evaluateSet1;
    }

    public Evaluate getFkevaluteEvaluateIdReply() {
        return fkevaluteEvaluateIdReply;
    }

    public void setFkevaluteEvaluateIdReply(Evaluate fkevaluteEvaluateIdReply) {
        this.fkevaluteEvaluateIdReply = fkevaluteEvaluateIdReply;
    }

    public Motel getFkevaluteMotelId() {
        return fkevaluteMotelId;
    }

    public void setFkevaluteMotelId(Motel fkevaluteMotelId) {
        this.fkevaluteMotelId = fkevaluteMotelId;
    }

    public User getFkevaluteUserIdRespondent() {
        return fkevaluteUserIdRespondent;
    }

    public void setFkevaluteUserIdRespondent(User fkevaluteUserIdRespondent) {
        this.fkevaluteUserIdRespondent = fkevaluteUserIdRespondent;
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
        if (!(object instanceof Evaluate)) {
            return false;
        }
        Evaluate other = (Evaluate) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.hht.springboot.pojo.Evaluate[ id=" + id + " ]";
    }
    
}
