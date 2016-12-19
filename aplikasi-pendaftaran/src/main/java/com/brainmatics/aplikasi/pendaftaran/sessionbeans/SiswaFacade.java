/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.brainmatics.aplikasi.pendaftaran.sessionbeans;

import com.brainmatics.aplikasi.pendaftaran.entity.Siswa;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author endymuhardin
 */
@Stateless
public class SiswaFacade extends AbstractFacade<Siswa> {

    @PersistenceContext(unitName = "com.brainmatics.aplikasi.pendaftaran_PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SiswaFacade() {
        super(Siswa.class);
    }
    
}
