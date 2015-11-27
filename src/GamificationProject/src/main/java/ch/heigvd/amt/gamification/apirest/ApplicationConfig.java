package ch.heigvd.amt.gamification.apirest;

import java.util.Set;
import javax.ws.rs.core.Application;
import org.glassfish.jersey.jackson.JacksonFeature;

/**
 *
 * @author Raphael Racine
 */
@javax.ws.rs.ApplicationPath("api")
public class ApplicationConfig extends Application {

  @Override
  public Set<Class<?>> getClasses() {
    Set<Class<?>> resources = new java.util.HashSet<>();
    addRestResourceClasses(resources);
    
    resources.add(JacksonFeature.class);
    return resources;
  }

  /**
   * Do not modify addRestResourceClasses() method.
   * It is automatically populated with
   * all resources defined in the project.
   * If required, comment out calling this method in getClasses().
   */
  private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(ch.heigvd.amt.gamification.apirest.BadgeRessource.class);
        resources.add(ch.heigvd.amt.gamification.apirest.EventRessource.class);
        resources.add(ch.heigvd.amt.gamification.apirest.JacksonConfigurationProvider.class);
        resources.add(ch.heigvd.amt.gamification.apirest.JsonExceptionMapper.class);
        resources.add(ch.heigvd.amt.gamification.apirest.LevelRessource.class);
        resources.add(ch.heigvd.amt.gamification.services.EventsProcessor.class);
  }

}
