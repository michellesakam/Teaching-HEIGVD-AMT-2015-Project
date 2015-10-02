



/* To change this license header, choose License Headers in Project Properties.
 /*
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.amt.gamification.services;

import javax.ejb.Stateless;

import ch.heigvd.amt.gamification.model.Account;
import ch.heigvd.amt.gamification.model.Application;
import java.util.List;

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

    @Override
    public long numbersOfAccount() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void createAccount(String email, String firstName, String lastName, String password) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Application> getAccountApps(String email) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void editAccount(String email, String newEmail, String newPassword, String newFirstName, String newLastName) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
