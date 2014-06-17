package com.br.me.trabalho_ban2.model;

import com.br.me.trabalho_ban2.model.Bibliografiacomplementar;
import com.br.me.trabalho_ban2.model.Cronograma;
import com.br.me.trabalho_ban2.model.Disciplina;
import com.br.me.trabalho_ban2.model.Periodo;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-06-16T23:46:20")
@StaticMetamodel(Plano.class)
public class Plano_ { 

    public static volatile CollectionAttribute<Plano, Cronograma> cronogramaCollection;
    public static volatile CollectionAttribute<Plano, Bibliografiacomplementar> bibliografiacomplementarCollection;
    public static volatile SingularAttribute<Plano, Disciplina> disciplinaidDisciplina;
    public static volatile SingularAttribute<Plano, String> metodologia;
    public static volatile SingularAttribute<Plano, String> criterios;
    public static volatile SingularAttribute<Plano, String> objetivoEspecifico;
    public static volatile SingularAttribute<Plano, Integer> idPlano;
    public static volatile SingularAttribute<Plano, String> objetivoGeral;
    public static volatile CollectionAttribute<Plano, Periodo> periodoCollection;

}