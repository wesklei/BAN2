package com.br.me.trabalho_ban2.model;

import com.br.me.trabalho_ban2.model.Curso;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-06-16T23:46:20")
@StaticMetamodel(Departamento.class)
public class Departamento_ { 

    public static volatile SingularAttribute<Departamento, String> nomeDep;
    public static volatile SingularAttribute<Departamento, Integer> idDepartamento;
    public static volatile CollectionAttribute<Departamento, Curso> cursoCollection;

}