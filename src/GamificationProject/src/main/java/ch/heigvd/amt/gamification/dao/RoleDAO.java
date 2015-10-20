/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.amt.gamification.dao;

import ch.heigvd.amt.gamification.model.Role;
import javax.annotation.security.RolesAllowed;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

/**
 *
 * @author parfait
 */
public class RoleDAO extends GenericDAO<Role, Long>   implements RoleDAOLocal {
//
//    @PersistenceContext
//    EntityManager em;
//
//    @Override
//    public long create(Role role) {
//        /**
//         * Pour créer un objet il suffit juste de le persiter, en utilisant la
//         * méthode merge ( elle met simplement l'objet dans le contexte de
//         * persistence )
//         */
//        em.persist(role);
//        em.flush();
//        return role.getId();
//    }
//
//    @Override
//    public void delete(Role role) {
//        Role tmpRole = null;
//        /**
//         * Pour supprimer un objet il suffit de le mettre dans le context de
//         * persistence et d'appliquer le remove sur cette objet
//         */
//        if (!em.contains(role)) {
//            tmpRole = findById(tmpRole.getId());
//        }
//        em.remove(tmpRole);
//    }
//
//    @Override
//    public void update(Role role) {
//        // pour updater un objet, il suffit de le trouver et de le merger        
//        findById(role.getId());
//        em.merge(role);
//    }
//
//    @Override
//    public Role findById(long id) {
//        Role result = null;
//        try {
//            result = (Role) em.createNamedQuery("Role.findById").setParameter("id", id);
//        } catch (NoResultException e) {
//            System.out.println("Erreur lors de l'acces à la database ");
//        }
//        return (Role) result;
//    }
//
//    @Override
//    public Role findAll() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public Role findByName(Role role) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }

}
