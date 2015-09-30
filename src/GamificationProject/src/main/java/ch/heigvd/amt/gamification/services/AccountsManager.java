/*
 * To change this license header, choose License Headers in Project Properties.
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
        Account a = new Account();
        a.setEmail("raphael.racine@heig-vd.ch");
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
        /**
         * Si vous modifiez la signature de cette méthode en updateAccount(Account accountToUpdate), vous devez procéder de
         * la manière suivante. Au moment où on arrive ici, partez du principe que "accountToUpdate" ne fait pas encore
         * partie du contexte de persistence (l'utilisateur vient de le créer avec un new(). Pour pouvoir faire la mise
         * à jour de la DB, vous devez amener accountToUpdate dans le contexte de persistence.
         * 
         * Pour cela, vous devez utiliser la méthode "merge" de l'entity manager: em.merge(accountToUpdate). A ce moment là,
         * JPA va regarder la valeur du champs marqué avec @Id dans accountToUpdate et faire une requête à la DB. Si il n'y
         * a pas encore de record avec cet id, alors un nouveau sera ajouté. Si il y en a déjà un (ce qui devrait être le cas),
         * alors il sera mis à jour.
         * 
         * Après avoir fait le merge, pas besoin de faire un em.update (ça n'existe pas) ou un em.persit. Simplement, quand la
         * transaction sera committée, l'update sera fait dans la db.
         * 
         * Un point très, très important, c'est que votre objet accountToUpdate doit contenir l'id (le champs marqué avec
         * @Id). Il est facile d'oublier ça, ce qui risque de créer des doublons (ou alors une exception si email est marqué
         * avec une contrainte d'unicité). Personnellement, j'aime bien avoir la signature suivante:
         * 
         * public void updateAccount(long accountId, Account accountToUpdate) {
         *   accountToUpdate.setId(accountId);
         *   Account updatedAccount = em.merge(accountToUpdate); // attention: updatedAccount est dans le contexte de persistence, mai pas accountToUpdate!
         *   return;
         * }
         */ 
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
