/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.br.me.trabalho_ban2.controller.session;

import com.br.me.trabalho_ban2.model.Prerequisitos;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Wesklei Migliorini <wesklei at wbezerra.com.br>
 */
@Stateless
public class PrerequisitosFacade extends AbstractFacade<Prerequisitos> {
    @PersistenceContext(unitName = "com.br.me_Trabalho_BAN2_war_0.1PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PrerequisitosFacade() {
        super(Prerequisitos.class);
    }
    
}
