/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.amt.gamification.services.dao;

import ch.heigvd.amt.gamification.model.entities.Role;
import javax.ejb.Stateless;

/**
 *
 * @author parfait
 */
@Stateless
public class RoleDAO extends GenericDAO<Role, Long> implements RoleDAOLocal{   

}
