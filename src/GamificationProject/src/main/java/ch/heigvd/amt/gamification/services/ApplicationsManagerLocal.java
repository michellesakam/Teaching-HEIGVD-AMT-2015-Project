package ch.heigvd.amt.gamification.services;

import ch.heigvd.amt.gamification.model.Application;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Olivier Liechti (olivier.liechti@heig-vd.ch)
 */
@Local
public interface ApplicationsManagerLocal {

  List<Application> findAll();
  
}
