/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.amt.gamification.services;

import javax.ejb.Local;
import ch.heigvd.amt.gamification.model.Account;

/**
 *
 * @author Raphaël Racine
 */
@Local
public interface LoginServiceLocal {    
    public Account login(String email, String password);            
}
