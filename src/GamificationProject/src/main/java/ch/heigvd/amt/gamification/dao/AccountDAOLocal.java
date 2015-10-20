/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.amt.gamification.dao;

import ch.heigvd.amt.gamification.model.entities.Account;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author parfait
 */
@Local
public interface AccountDAOLocal extends IGenericDAO<Account, Long> {
    public Account login(String email);
    public long numbersOfAccount();
}
