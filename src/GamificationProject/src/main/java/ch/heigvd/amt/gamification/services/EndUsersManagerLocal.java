/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.amt.gamification.services;

import javax.ejb.Local;

/**
 *
 * @author Raphaël Racine
 */
@Local
public interface EndUsersManagerLocal {
    public long numberOfEndUsers(int numberOfDay);
}
