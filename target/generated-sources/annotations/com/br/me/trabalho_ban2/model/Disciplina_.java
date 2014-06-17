package com.br.me.trabalho_ban2.model;

import com.br.me.trabalho_ban2.model.Bibliografiageral;
import com.br.me.trabalho_ban2.model.Curso;
import com.br.me.trabalho_ban2.model.Plano;
import com.br.me.trabalho_ban2.model.Prerequisitos;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-06-16T23:46:20")
@StaticMetamodel(Disciplina.class)
public class Disciplina_ { 

    public static volatile CollectionAttribute<Disciplina, Prerequisitos> prerequisitosCollection;
    public static volatile SingularAttribute<Disciplina, Curso> cursoidCurso;
    public static volatile SingularAttribute<Disciplina, String> sigla;
    public static volatile SingularAttribute<Disciplina, Integer> chPratica;
    public static volatile SingularAttribute<Disciplina, Integer> idDisciplina;
    public static volatile SingularAttribute<Disciplina, String> ementa;
    public static volatile SingularAttribute<Disciplina, Integer> chTeorica;
    public static volatile SingularAttribute<Disciplina, String> nomeDisc;
    public static volatile SingularAttribute<Disciplina, Integer> chTotal;
    public static volatile CollectionAttribute<Disciplina, Bibliografiageral> bibliografiageralCollection;
    public static volatile CollectionAttribute<Disciplina, Plano> planoCollection;

}