package ch.heigvd.amt.gamification.services;

import ch.heigvd.amt.gamification.model.Account;
import ch.heigvd.amt.gamification.model.ApiKey;
import ch.heigvd.amt.gamification.model.Application;
import ch.heigvd.amt.gamification.util.Chance;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 * This service is used to generate test data.
 * 
 * @author Olivier Liechti (olivier.liechti@heig-vd.ch)
 */
@Stateless
public class TestDataManager implements TestDataManagerLocal {
  
  @EJB
  private AccountsManagerLocal accountsManager;
  
  @EJB
  private ApplicationsManagerLocal applicationsManager;

  @Override
  public void generateTestData() {
      
        String password = "toor";
        String nom;
        String prenom;
        
        for(int i = 0; i < 20; ++i)
        {
            Account a = new Account();
            nom = Chance.randomLastName();
            prenom = Chance.randomLastName();
            a.setEmail(nom + "." + prenom + i + "@google.ch");
            a.setPassword(password);
            a.setFirstName(prenom);
            a.setLastName(nom);
            accountsManager.createAccount(a);
        }
        
        
        Account createur = new Account();
        createur.setEmail("raphael.racine@heig-vd.ch");
        createur.setPassword("toor");
        accountsManager.createAccount(createur);
        
        Application app = new Application();
        app.setIsEnable(true);
        app.setName("Lego Creator");
        app.setDescription("Construisez vos legos");
        
        applicationsManager.assignApplicationToAccount(app, createur);
  } 

}
