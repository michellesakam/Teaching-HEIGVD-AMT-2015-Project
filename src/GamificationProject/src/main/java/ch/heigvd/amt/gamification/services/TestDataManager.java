package ch.heigvd.amt.gamification.services;

import ch.heigvd.amt.gamification.services.dao.ApplicationDAOLocal;
import ch.heigvd.amt.gamification.model.entities.Account;
import ch.heigvd.amt.gamification.model.entities.Application;

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
  private ApplicationDAOLocal applicationDAO;

  @Override
  public void generateTestData() {
      
        String password = "toor";
        String nom;
        String prenom;
        

        for(int i = 0; i < 1000; ++i)
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
        createur.setFirstName("Raphaël");
        createur.setLastName("Racine");
        accountsManager.createAccount(createur);
        
        /* Création d'une première application */
        Application app1 = new Application();
        app1.setIsEnable(true);
        app1.setName("Lego Creator");
        app1.setDescription("Construisez vos legos");
        
        applicationDAO.assignApplicationToAccount(app1, createur);
        
        /* Création d'une deuxième application */
        Application app2 = new Application();
        app2.setIsEnable(false);
        app2.setName("The Elder Scroll's 5 : Skyrim");
        app2.setDescription("Tuez votre cheval !");
        
        applicationDAO.assignApplicationToAccount(app2, createur);
        
        Account createur2 = new Account();
        createur2.setEmail("olivier.liechti@heig-vd.ch");
        createur2.setPassword("toor");
        createur2.setFirstName("Olivier");
        createur2.setLastName("Liechti");
        accountsManager.createAccount(createur2);        
        
        /* Création d'une troisième application (par un autre créateur) */
        Application app3 = new Application();
        app3.setIsEnable(true);
        app3.setName("Google Chrome");
        app3.setDescription("Surfez sur Internet !");
        
        applicationDAO.assignApplicationToAccount(app3, createur2);               
  } 

}
