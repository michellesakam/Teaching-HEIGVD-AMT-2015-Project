



/* To change this license header, choose License Headers in Project Properties.
 /*
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.amt.gamification.services;

import javax.ejb.Stateless;

import ch.heigvd.amt.gamification.model.Account;

/**
 *
 * @author Raphaël Racine
 */
@Stateless
public class AccountsManager implements AccountsManagerLocal {

    @Override
    public Account login(String email, String password) {
        // TODO: return an Account if he existe with this email and this password, else return null
        return generateFakeAccount();
    }
    
    private Account generateFakeAccount() {
        return new Account();
    }

}
