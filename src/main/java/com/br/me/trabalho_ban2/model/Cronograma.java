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
@Table(name = "cronograma")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cronograma.findAll", query = "SELECT c FROM Cronograma c"),
    @NamedQuery(name = "Cronograma.findByIdCronograma", query = "SELECT c FROM Cronograma c WHERE c.idCronograma = :idCronograma"),
    @NamedQuery(name = "Cronograma.findByChParcial", query = "SELECT c FROM Cronograma c WHERE c.chParcial = :chParcial"),
    @NamedQuery(name = "Cronograma.findByConteudo", query = "SELECT c FROM Cronograma c WHERE c.conteudo = :conteudo"),
    @NamedQuery(name = "Cronograma.findByAvaliacao", query = "SELECT c FROM Cronograma c WHERE c.avaliacao = :avaliacao")})
public class Cronograma implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idCronograma")
    private Integer idCronograma;
    @Basic(optional = false)
    @NotNull
    @Column(name = "chParcial")
    private int chParcial;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "conteudo")
    private String conteudo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "avaliacao")
    private String avaliacao;
    @JoinColumn(name = "Plano_idPlano", referencedColumnName = "idPlano")
    @ManyToOne(optional = false)
    private Plano planoidPlano;

    public Cronograma() {
    }

    public Cronograma(Integer idCronograma) {
        this.idCronograma = idCronograma;
    }

    public Cronograma(Integer idCronograma, int chParcial, String conteudo, String avaliacao) {
        this.idCronograma = idCronograma;
        this.chParcial = chParcial;
        this.conteudo = conteudo;
        this.avaliacao = avaliacao;
    }

    public Integer getIdCronograma() {
        return idCronograma;
    }

    public void setIdCronograma(Integer idCronograma) {
        this.idCronograma = idCronograma;
    }

    public int getChParcial() {
        return chParcial;
    }

    public void setChParcial(int chParcial) {
        this.chParcial = chParcial;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public String getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(String avaliacao) {
        this.avaliacao = avaliacao;
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
        hash += (idCronograma != null ? idCronograma.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cronograma)) {
            return false;
        }
        Cronograma other = (Cronograma) object;
        if ((this.idCronograma == null && other.idCronograma != null) || (this.idCronograma != null && !this.idCronograma.equals(other.idCronograma))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.br.me.trabalho_ban2.model.Cronograma[ idCronograma=" + idCronograma + " ]";
    }
    
}
