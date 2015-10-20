/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.amt.gamification.dao;

import ch.heigvd.amt.gamification.model.entities.Account;
import javax.ejb.Local;

/**
 *
 * @author parfait new : exceptions, changement de la signature des méthodes.
 * But : ici on implémentes les méthodes qui sont à la class Account
 */
@Local
public interface AccountDAOLocal extends IGenericDAO<Account, Long> {
    public Account login(String email);
    public long numbersOfAccount();
}
