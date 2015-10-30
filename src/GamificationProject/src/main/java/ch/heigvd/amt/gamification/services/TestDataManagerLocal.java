
package ch.heigvd.amt.gamification.services;

import javax.ejb.Local;

/**
 *
 * @author Olivier Liechti (olivier.liechti@heig-vd.ch)
 */
@Local
public interface TestDataManagerLocal {

  void generateTestData();
  
}
