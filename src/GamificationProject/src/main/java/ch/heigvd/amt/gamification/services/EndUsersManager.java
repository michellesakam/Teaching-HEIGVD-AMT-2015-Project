/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.amt.gamification.services;

import javax.ejb.Stateless;

/**
 *
 * @author Raphaël Racine
 */
@Stateless
public class EndUsersManager implements EndUsersManagerLocal {

    @Override
    public long numberOfEndUsers(int numberOfDay) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
