/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.amt.gamification.dao;

import ch.heigvd.amt.gamification.model.entities.EndUser;

/**
 *
 * @author parfait
 */
public interface EndUserDAOLocal extends IGenericDAO<EndUser, Long> {
    public long numberOfEndUsers(int numberOfDay);
}
