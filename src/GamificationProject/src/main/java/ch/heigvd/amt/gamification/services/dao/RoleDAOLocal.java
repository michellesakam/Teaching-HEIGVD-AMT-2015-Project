/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.amt.gamification.services.dao;

import ch.heigvd.amt.gamification.model.entities.Role;
import javax.ejb.Local;

/**
 *
 * @author parfait
 */
@Local
public interface RoleDAOLocal extends IGenericDAO<Role, Long> {

}
