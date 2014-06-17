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
@Table(name = "bibliografiageral")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Bibliografiageral.findAll", query = "SELECT b FROM Bibliografiageral b"),
    @NamedQuery(name = "Bibliografiageral.findByIdBibliografiaGeral", query = "SELECT b FROM Bibliografiageral b WHERE b.idBibliografiaGeral = :idBibliografiaGeral"),
    @NamedQuery(name = "Bibliografiageral.findByAutor", query = "SELECT b FROM Bibliografiageral b WHERE b.autor = :autor"),
    @NamedQuery(name = "Bibliografiageral.findByTitulo", query = "SELECT b FROM Bibliografiageral b WHERE b.titulo = :titulo"),
    @NamedQuery(name = "Bibliografiageral.findByAno", query = "SELECT b FROM Bibliografiageral b WHERE b.ano = :ano")})
public class Bibliografiageral implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idBibliografiaGeral")
    private Integer idBibliografiaGeral;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "autor")
    private String autor;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "titulo")
    private String titulo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ano")
    private int ano;
    @JoinColumn(name = "Disciplina_idDisciplina", referencedColumnName = "idDisciplina")
    @ManyToOne(optional = false)
    private Disciplina disciplinaidDisciplina;

    public Bibliografiageral() {
    }

    public Bibliografiageral(Integer idBibliografiaGeral) {
        this.idBibliografiaGeral = idBibliografiaGeral;
    }

    public Bibliografiageral(Integer idBibliografiaGeral, String autor, String titulo, int ano) {
        this.idBibliografiaGeral = idBibliografiaGeral;
        this.autor = autor;
        this.titulo = titulo;
        this.ano = ano;
    }

    public Integer getIdBibliografiaGeral() {
        return idBibliografiaGeral;
    }

    public void setIdBibliografiaGeral(Integer idBibliografiaGeral) {
        this.idBibliografiaGeral = idBibliografiaGeral;
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

    public Disciplina getDisciplinaidDisciplina() {
        return disciplinaidDisciplina;
    }

    public void setDisciplinaidDisciplina(Disciplina disciplinaidDisciplina) {
        this.disciplinaidDisciplina = disciplinaidDisciplina;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idBibliografiaGeral != null ? idBibliografiaGeral.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Bibliografiageral)) {
            return false;
        }
        Bibliografiageral other = (Bibliografiageral) object;
        if ((this.idBibliografiaGeral == null && other.idBibliografiaGeral != null) || (this.idBibliografiaGeral != null && !this.idBibliografiaGeral.equals(other.idBibliografiaGeral))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.br.me.trabalho_ban2.model.Bibliografiageral[ idBibliografiaGeral=" + idBibliografiaGeral + " ]";
    }
    
}
