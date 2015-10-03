package ch.heigvd.amt.gamification.services;

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
    accountsManager.createAccount("jdoe@acme.com", "John", "Doe", "passw0rd");
  }
  
  
  

}
