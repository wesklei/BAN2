package com.br.me.trabalho_ban2.model;

import com.br.me.trabalho_ban2.model.Plano;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-06-16T23:46:20")
@StaticMetamodel(Periodo.class)
public class Periodo_ { 

    public static volatile SingularAttribute<Periodo, Integer> ano;
    public static volatile SingularAttribute<Periodo, Integer> idPeriodo;
    public static volatile SingularAttribute<Periodo, Plano> planoidPlano;
    public static volatile SingularAttribute<Periodo, Integer> semestre;

}