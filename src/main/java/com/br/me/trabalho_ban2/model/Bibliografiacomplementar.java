/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.br.me.trabalho_ban2.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Wesklei Migliorini <wesklei at wbezerra.com.br>
 */
@Entity
@Table(name = "bibliografiacomplementar")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Bibliografiacomplementar.findAll", query = "SELECT b FROM Bibliografiacomplementar b"),
    @NamedQuery(name = "Bibliografiacomplementar.findByIdBibliografiaComplementar", query = "SELECT b FROM Bibliografiacomplementar b WHERE b.idBibliografiaComplementar = :idBibliografiaComplementar"),
    @NamedQuery(name = "Bibliografiacomplementar.findByAutor", query = "SELECT b FROM Bibliografiacomplementar b WHERE b.autor = :autor"),
    @NamedQuery(name = "Bibliografiacomplementar.findByTitulo", query = "SELECT b FROM Bibliografiacomplementar b WHERE b.titulo = :titulo"),
    @NamedQuery(name = "Bibliografiacomplementar.findByAno", query = "SELECT b FROM Bibliografiacomplementar b WHERE b.ano = :ano")})
public class Bibliografiacomplementar implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idBibliografiaComplementar")
    private Integer idBibliografiaComplementar;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "autor")
    private String autor;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "titulo")
    private String titulo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ano")
    private int ano;
    @JoinColumn(name = "Plano_idPlano", referencedColumnName = "idPlano")
    @ManyToOne(optional = false)
    private Plano planoidPlano;

    public Bibliografiacomplementar() {
    }

    public Bibliografiacomplementar(Integer idBibliografiaComplementar) {
        this.idBibliografiaComplementar = idBibliografiaComplementar;
    }

    public Bibliografiacomplementar(Integer idBibliografiaComplementar, String autor, String titulo, int ano) {
        this.idBibliografiaComplementar = idBibliografiaComplementar;
        this.autor = autor;
        this.titulo = titulo;
        this.ano = ano;
    }

    public Integer getIdBibliografiaComplementar() {
        return idBibliografiaComplementar;
    }

    public void setIdBibliografiaComplementar(Integer idBibliografiaComplementar) {
        this.idBibliografiaComplementar = idBibliografiaComplementar;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public Plano getPlanoidPlano() {
        return planoidPlano;
    }

    public void setPlanoidPlano(Plano planoidPlano) {
        this.planoidPlano = planoidPlano;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idBibliografiaComplementar != null ? idBibliografiaComplementar.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Bibliografiacomplementar)) {
            return false;
        }
        Bibliografiacomplementar other = (Bibliografiacomplementar) object;
        if ((this.idBibliografiaComplementar == null && other.idBibliografiaComplementar != null) || (this.idBibliografiaComplementar != null && !this.idBibliografiaComplementar.equals(other.idBibliografiaComplementar))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.br.me.trabalho_ban2.model.Bibliografiacomplementar[ idBibliografiaComplementar=" + idBibliografiaComplementar + " ]";
    }
    
}
