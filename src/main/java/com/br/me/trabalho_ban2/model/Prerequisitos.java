/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.br.me.trabalho_ban2.model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Wesklei Migliorini <wesklei at wbezerra.com.br>
 */
@Entity
@Table(name = "prerequisitos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Prerequisitos.findAll", query = "SELECT p FROM Prerequisitos p"),
    @NamedQuery(name = "Prerequisitos.findByIdPreRequisitos", query = "SELECT p FROM Prerequisitos p WHERE p.idPreRequisitos = :idPreRequisitos")})
public class Prerequisitos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idPreRequisitos")
    private Integer idPreRequisitos;
    @ManyToMany(mappedBy = "prerequisitosCollection")
    private Collection<Disciplina> disciplinaCollection;

    public Prerequisitos() {
    }

    public Prerequisitos(Integer idPreRequisitos) {
        this.idPreRequisitos = idPreRequisitos;
    }

    public Integer getIdPreRequisitos() {
        return idPreRequisitos;
    }

    public void setIdPreRequisitos(Integer idPreRequisitos) {
        this.idPreRequisitos = idPreRequisitos;
    }

    @XmlTransient
    public Collection<Disciplina> getDisciplinaCollection() {
        return disciplinaCollection;
    }

    public void setDisciplinaCollection(Collection<Disciplina> disciplinaCollection) {
        this.disciplinaCollection = disciplinaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPreRequisitos != null ? idPreRequisitos.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Prerequisitos)) {
            return false;
        }
        Prerequisitos other = (Prerequisitos) object;
        if ((this.idPreRequisitos == null && other.idPreRequisitos != null) || (this.idPreRequisitos != null && !this.idPreRequisitos.equals(other.idPreRequisitos))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.br.me.trabalho_ban2.model.Prerequisitos[ idPreRequisitos=" + idPreRequisitos + " ]";
    }
    
}
