package ch.heigvd.amt.gamification.services;

import ch.heigvd.amt.gamification.model.Application;
import java.util.LinkedList;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author Olivier Liechti (olivier.liechti@heig-vd.ch)
 */
@Stateless
public class ApplicationsManager implements ApplicationsManagerLocal {

  @Override
  public List<Application> findAll() {
    // TODO: replace dummy data with real data from DB
    return generateDummyData();
  }
  
  private List<Application> generateDummyData() {
    Application app1 = new Application("my first app", "enabled", "just for fun", null);
    Application app2 = new Application("my second app", "disable", "just a test", null);
    Application app3 = new Application("my third app", "enabled", "a test, again", null);
    List<Application> result = new LinkedList<>();
    result.add(app1);
    result.add(app2);
    result.add(app3);
    return result;
  }
  
  

}
