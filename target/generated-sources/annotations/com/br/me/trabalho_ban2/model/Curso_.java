package com.br.me.trabalho_ban2.model;

import com.br.me.trabalho_ban2.model.Departamento;
import com.br.me.trabalho_ban2.model.Disciplina;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-06-16T23:46:20")
@StaticMetamodel(Curso.class)
public class Curso_ { 

    public static volatile SingularAttribute<Curso, String> nomeCurso;
    public static volatile CollectionAttribute<Curso, Disciplina> disciplinaCollection;
    public static volatile SingularAttribute<Curso, Integer> idCurso;
    public static volatile SingularAttribute<Curso, Departamento> departamentoidDepartamento;

}