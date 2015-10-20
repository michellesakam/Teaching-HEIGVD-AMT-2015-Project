/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.amt.gamification.dao;

import ch.heigvd.amt.gamification.model.AbstractDomainModelEntity;
import ch.heigvd.amt.gamification.model.Application;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

/**
 *
 * @author parfait
 */
public class ApplicationDAO extends GenericDAO<Application, Long>  implements ApplicationDAOLocal {

    @PersistenceContext
    EntityManager em;

}

//
//    @Override
//    public long create(Application application) {
//        /**
//         * Pour créer un objet il suffit juste de le persiter, en utilisant la
//         * méthode merge ( elle met simplement l'objet dans le contexte de
//         * persistence )
//         */
//        em.persist(application);
//        em.flush();
//        return application.getId();
//    }
//
//    @Override
//    public void delete(Application application) {
//        Application tmpApplication = null;
//        /**
//         * Pour supprimer un objet il suffit de le mettre dans le context de
//         * persistence et d'appliquer le remove sur cette objet
//         */
//        if (!em.contains(application)) {
//            tmpApplication = findById(tmpApplication.getId());
//        }
//        em.remove(tmpApplication);
//    }
//
//    @Override
//    public void update(Application application) {
//        // pour updater un objet, il suffit de le trouver et de le merger        
//        findById(application.getId());
//        em.merge(application);
//    }
//
//    @Override
//    public Application findById(long id) {
//         Application result = null;
//        try {
//            result = (Application) em.createNamedQuery("Application.findById").setParameter("id", id);
//        } catch (NoResultException e) {
//            System.out.println("Erreur lors de l'acces à la database ");
//        }
//        return (Application) result;
//    }
//
//    @Override
//    public List<Application> findAll() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public Application findByName(Application k) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }