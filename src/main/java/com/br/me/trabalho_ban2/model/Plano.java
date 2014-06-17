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
@Table(name = "plano")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Plano.findAll", query = "SELECT p FROM Plano p"),
    @NamedQuery(name = "Plano.findByIdPlano", query = "SELECT p FROM Plano p WHERE p.idPlano = :idPlano"),
    @NamedQuery(name = "Plano.findByObjetivoGeral", query = "SELECT p FROM Plano p WHERE p.objetivoGeral = :objetivoGeral"),
    @NamedQuery(name = "Plano.findByObjetivoEspecifico", query = "SELECT p FROM Plano p WHERE p.objetivoEspecifico = :objetivoEspecifico"),
    @NamedQuery(name = "Plano.findByMetodologia", query = "SELECT p FROM Plano p WHERE p.metodologia = :metodologia"),
    @NamedQuery(name = "Plano.findByCriterios", query = "SELECT p FROM Plano p WHERE p.criterios = :criterios")})
public class Plano implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idPlano")
    private Integer idPlano;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "objetivoGeral")
    private String objetivoGeral;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "objetivoEspecifico")
    private String objetivoEspecifico;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "metodologia")
    private String metodologia;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "criterios")
    private String criterios;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "planoidPlano")
    private Collection<Cronograma> cronogramaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "planoidPlano")
    private Collection<Periodo> periodoCollection;
    @JoinColumn(name = "Disciplina_idDisciplina", referencedColumnName = "idDisciplina")
    @ManyToOne(optional = false)
    private Disciplina disciplinaidDisciplina;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "planoidPlano")
    private Collection<Bibliografiacomplementar> bibliografiacomplementarCollection;

    public Plano() {
    }

    public Plano(Integer idPlano) {
        this.idPlano = idPlano;
    }

    public Plano(Integer idPlano, String objetivoGeral, String objetivoEspecifico, String metodologia, String criterios) {
        this.idPlano = idPlano;
        this.objetivoGeral = objetivoGeral;
        this.objetivoEspecifico = objetivoEspecifico;
        this.metodologia = metodologia;
        this.criterios = criterios;
    }

    public Integer getIdPlano() {
        return idPlano;
    }

    public void setIdPlano(Integer idPlano) {
        this.idPlano = idPlano;
    }

    public String getObjetivoGeral() {
        return objetivoGeral;
    }

    public void setObjetivoGeral(String objetivoGeral) {
        this.objetivoGeral = objetivoGeral;
    }

    public String getObjetivoEspecifico() {
        return objetivoEspecifico;
    }

    public void setObjetivoEspecifico(String objetivoEspecifico) {
        this.objetivoEspecifico = objetivoEspecifico;
    }

    public String getMetodologia() {
        return metodologia;
    }

    public void setMetodologia(String metodologia) {
        this.metodologia = metodologia;
    }

    public String getCriterios() {
        return criterios;
    }

    public void setCriterios(String criterios) {
        this.criterios = criterios;
    }

    @XmlTransient
    public Collection<Cronograma> getCronogramaCollection() {
        return cronogramaCollection;
    }

    public void setCronogramaCollection(Collection<Cronograma> cronogramaCollection) {
        this.cronogramaCollection = cronogramaCollection;
    }

    @XmlTransient
    public Collection<Periodo> getPeriodoCollection() {
        return periodoCollection;
    }

    public void setPeriodoCollection(Collection<Periodo> periodoCollection) {
        this.periodoCollection = periodoCollection;
    }

    public Disciplina getDisciplinaidDisciplina() {
        return disciplinaidDisciplina;
    }

    public void setDisciplinaidDisciplina(Disciplina disciplinaidDisciplina) {
        this.disciplinaidDisciplina = disciplinaidDisciplina;
    }

    @XmlTransient
    public Collection<Bibliografiacomplementar> getBibliografiacomplementarCollection() {
        return bibliografiacomplementarCollection;
    }

    public void setBibliografiacomplementarCollection(Collection<Bibliografiacomplementar> bibliografiacomplementarCollection) {
        this.bibliografiacomplementarCollection = bibliografiacomplementarCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPlano != null ? idPlano.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Plano)) {
            return false;
        }
        Plano other = (Plano) object;
        if ((this.idPlano == null && other.idPlano != null) || (this.idPlano != null && !this.idPlano.equals(other.idPlano))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.br.me.trabalho_ban2.model.Plano[ idPlano=" + idPlano + " ]";
    }
    
}
