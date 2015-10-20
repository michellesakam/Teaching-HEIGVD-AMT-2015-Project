/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.amt.gamification.dao;

import ch.heigvd.amt.gamification.model.AbstractDomainModelEntity;
import ch.heigvd.amt.gamification.model.EndUser;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

/**
 *
 * @author parfait
 */
public class EndUserDAO extends GenericDAO<EndUser, Long> implements EndUserDAOLocal {

    @PersistenceContext
    EntityManager em;

//    @Override
//    public long create(EndUser endUser) {
//        /**
//         * Pour créer un objet il suffit juste de le persiter, en utilisant la
//         * méthode merge ( elle met simplement l'objet dans le contexte de
//         * persistence )
//         */
//        em.persist(endUser);
//        em.flush();
//        return endUser.getId();
//    }
//
//    @Override
//    public void delete(EndUser endUser) {
//
//        EndUser tmpEndUser = null;
//        /**
//         * Pour supprimer un objet il suffit de le mettre dans le context de
//         * persistence et d'appliquer le remove sur cette objet
//         */
//        if (!em.contains(endUser)) {
//            tmpEndUser = findById(tmpEndUser.getId());
//        }
//        em.remove(tmpEndUser);
//    }
//
//    @Override
//    public void update(EndUser endUser) {
//        // pour updater un objet, il suffit de le trouver et de le merger        
//        findById(endUser.getId());
//        em.merge(endUser);
//    }
//
//    @Override
//    public EndUser findById(long id) {
//        EndUser result = null;
//        try {
//            result = (EndUser) em.createNamedQuery("EndUser.findById").setParameter("id", id);
//        } catch (NoResultException e) {
//            System.out.println("Erreur lors de l'acces à la database ");
//        }
//        return (EndUser) result;
//    }
//
//    @Override
//    public EndUser findAll() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public EndUser findByName(EndUser endUser) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }

}
