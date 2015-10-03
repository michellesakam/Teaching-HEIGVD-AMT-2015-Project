package ch.heigvd.amt.gamification.services;

import ch.heigvd.amt.gamification.model.Account;
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

  @Override
  public void generateTestData() {
    Account account = new Account();
    account.setFirstName("John");
    account.setLastName("Doe");
    account.setPassword("passw0rd");
    account.setEmail("jdoe@acme.com");
    accountsManager.createAccount(account);
  } 

}
