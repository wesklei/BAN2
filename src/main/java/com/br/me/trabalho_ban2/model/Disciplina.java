/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.br.me.trabalho_ban2.model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Wesklei Migliorini <wesklei at wbezerra.com.br>
 */
@Entity
@Table(name = "disciplina")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Disciplina.findAll", query = "SELECT d FROM Disciplina d"),
    @NamedQuery(name = "Disciplina.findByIdDisciplina", query = "SELECT d FROM Disciplina d WHERE d.idDisciplina = :idDisciplina"),
    @NamedQuery(name = "Disciplina.findByNomeDisc", query = "SELECT d FROM Disciplina d WHERE d.nomeDisc = :nomeDisc"),
    @NamedQuery(name = "Disciplina.findBySigla", query = "SELECT d FROM Disciplina d WHERE d.sigla = :sigla"),
    @NamedQuery(name = "Disciplina.findByChTotal", query = "SELECT d FROM Disciplina d WHERE d.chTotal = :chTotal"),
    @NamedQuery(name = "Disciplina.findByChTeorica", query = "SELECT d FROM Disciplina d WHERE d.chTeorica = :chTeorica"),
    @NamedQuery(name = "Disciplina.findByChPratica", query = "SELECT d FROM Disciplina d WHERE d.chPratica = :chPratica"),
    @NamedQuery(name = "Disciplina.findByEmenta", query = "SELECT d FROM Disciplina d WHERE d.ementa = :ementa")})
public class Disciplina implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idDisciplina")
    private Integer idDisciplina;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "nome_disc")
    private String nomeDisc;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "sigla")
    private String sigla;
    @Basic(optional = false)
    @NotNull
    @Column(name = "chTotal")
    private int chTotal;
    @Basic(optional = false)
    @NotNull
    @Column(name = "chTeorica")
    private int chTeorica;
    @Basic(optional = false)
    @NotNull
    @Column(name = "chPratica")
    private int chPratica;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "ementa")
    private String ementa;
    @JoinTable(name = "disciplina_has_prerequisitos", joinColumns = {
        @JoinColumn(name = "Disciplina_idDisciplina", referencedColumnName = "idDisciplina")}, inverseJoinColumns = {
        @JoinColumn(name = "PreRequisitos_idPreRequisitos", referencedColumnName = "idPreRequisitos")})
    @ManyToMany
    private Collection<Prerequisitos> prerequisitosCollection;
    @JoinColumn(name = "Curso_idCurso", referencedColumnName = "idCurso")
    @ManyToOne(optional = false)
    private Curso cursoidCurso;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "disciplinaidDisciplina")
    private Collection<Plano> planoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "disciplinaidDisciplina")
    private Collection<Bibliografiageral> bibliografiageralCollection;

    public Disciplina() {
    }

    public Disciplina(Integer idDisciplina) {
        this.idDisciplina = idDisciplina;
    }

    public Disciplina(Integer idDisciplina, String nomeDisc, String sigla, int chTotal, int chTeorica, int chPratica, String ementa) {
        this.idDisciplina = idDisciplina;
        this.nomeDisc = nomeDisc;
        this.sigla = sigla;
        this.chTotal = chTotal;
        this.chTeorica = chTeorica;
        this.chPratica = chPratica;
        this.ementa = ementa;
    }

    public Integer getIdDisciplina() {
        return idDisciplina;
    }

    public void setIdDisciplina(Integer idDisciplina) {
        this.idDisciplina = idDisciplina;
    }

    public String getNomeDisc() {
        return nomeDisc;
    }

    public void setNomeDisc(String nomeDisc) {
        this.nomeDisc = nomeDisc;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public int getChTotal() {
        return chTotal;
    }

    public void setChTotal(int chTotal) {
        this.chTotal = chTotal;
    }

    public int getChTeorica() {
        return chTeorica;
    }

    public void setChTeorica(int chTeorica) {
        this.chTeorica = chTeorica;
    }

    public int getChPratica() {
        return chPratica;
    }

    public void setChPratica(int chPratica) {
        this.chPratica = chPratica;
    }

    public String getEmenta() {
        return ementa;
    }

    public void setEmenta(String ementa) {
        this.ementa = ementa;
    }

    @XmlTransient
    public Collection<Prerequisitos> getPrerequisitosCollection() {
        return prerequisitosCollection;
    }

    public void setPrerequisitosCollection(Collection<Prerequisitos> prerequisitosCollection) {
        this.prerequisitosCollection = prerequisitosCollection;
    }

    public Curso getCursoidCurso() {
        return cursoidCurso;
    }

    public void setCursoidCurso(Curso cursoidCurso) {
        this.cursoidCurso = cursoidCurso;
    }

    @XmlTransient
    public Collection<Plano> getPlanoCollection() {
        return planoCollection;
    }

    public void setPlanoCollection(Collection<Plano> planoCollection) {
        this.planoCollection = planoCollection;
    }

    @XmlTransient
    public Collection<Bibliografiageral> getBibliografiageralCollection() {
        return bibliografiageralCollection;
    }

    public void setBibliografiageralCollection(Collection<Bibliografiageral> bibliografiageralCollection) {
        this.bibliografiageralCollection = bibliografiageralCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDisciplina != null ? idDisciplina.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Disciplina)) {
            return false;
        }
        Disciplina other = (Disciplina) object;
        if ((this.idDisciplina == null && other.idDisciplina != null) || (this.idDisciplina != null && !this.idDisciplina.equals(other.idDisciplina))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.br.me.trabalho_ban2.model.Disciplina[ idDisciplina=" + idDisciplina + " ]";
    }
    
}
