
package ch.heigvd.amt.concurrentupdategamyclienttest;

import ch.heigvd.amt.gamification.client.dto.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;
import org.glassfish.jersey.jackson.JacksonFeature;
/**
 *
 * @author michelle vanessa
 */
public class ConcurrentUpdateGamificationClient {

  private final long numberOfApplication = 1;
  private final long numberOfEndUsers = 5;
  private final long numberOfEventsPerEndUser = 2;
  private final int numberOfConcurrentThreads = 1;
  private static final String APIKEYFORTEST = "ABC-123";

  private static final Logger LOG = Logger.getLogger(ConcurrentUpdateGamificationClient.class.getName());
  private int numberOfResponses = 0;

  Client client;
  final ExpectedState expectedState = new ExpectedState();

  private synchronized void incCounter() {
    numberOfResponses++;
  }

  public ConcurrentUpdateGamificationClient() {
    client = ClientBuilder.newClient().register(JacksonFeature.class);
  }
      
  private Response PostEvents(String apikey,String type,String endUserNumber, int nbcomment){
      Date date = new Date();
      EventDTO event = new EventDTO();
      event.setType(type);
      event.setApiKey(apikey);
      event.setEndUserNumber(endUserNumber);
      event.setTimestamp(date);
      HashMap<String, Object> properties = new HashMap<>();
      properties.put("nbComments", nbcomment);
      event.setProperties(properties);
      final WebTarget target = client.target("http://localhost:8080/ConcurrentTransactionsServer/api").path("events");
      target.request().header("Authorization", apikey);
      return target.request().post(Entity.json(event));
  }

  private List<EndUserDTO> getEndsUsersListFromServer(String apikey) {
    final WebTarget target = client.target("http://localhost:8080/GamificationProject/api").path("applicationsEndUsers");
    target.request().header("Authorization",apikey );
    GenericType<List<EndUserDTO>> endusers = new GenericType<List<EndUserDTO>>(){};
    return target.request().get(endusers);
    
  }
  
  private long getBadgesNbOfAnEndUser(String apikey,String endUserNumber){
    final WebTarget target = client.target("http://localhost:8080/GamificationProject/api").path("statsEndUser/badges/{" + endUserNumber +"}");
    target.request().header("Authorization",apikey );
      return 0;
  }
  
  private long getPointsNbOfAnEndUser(String apikey,String endUserNumber){
    final WebTarget target = client.target("http://localhost:8080/GamificationProject/api").path("statsEndUser/points/{" + endUserNumber +"}");
    target.request().header("Authorization",apikey);
      return 0;
  }

  private void test() {

    
    ExecutorService executor = Executors.newFixedThreadPool(numberOfConcurrentThreads);
    final WebTarget target = client.target("http://localhost:8080/GamificationProject/api").path("events");

    for (int enduser = 1; enduser <= numberOfEndUsers; enduser++) {
      for (int event = 0; event < numberOfEventsPerEndUser; event++) {
      LOG.log(Level.INFO, "Generating {0} events for enduser {1}", new Object[]{numberOfEventsPerEndUser, "enduser" + "/" + numberOfEndUsers});
        Runnable task = new Runnable() {
          @Override
          public void run() {             
            	Random r = new Random();
		int nbComments = r.nextInt((102 - 98) + 1) + 98;
                String endusernumber =  "enduser"+nbComments;
                
                EventDTO eventdto = new EventDTO();
                eventdto.setApiKey(APIKEYFORTEST);
                eventdto.setEndUserNumber(endusernumber);
                eventdto.setTimestamp(new Date());
                eventdto.setType("comment");
                HashMap<String, Object> properties = new HashMap<>();
                
                properties.put("nbComments",nbComments);
           
                eventdto.setProperties(properties);
                
                Response response = PostEvents(APIKEYFORTEST,"comment",endusernumber,nbComments);
            if (response.getStatus() < 200 || response.getStatus() >= 300) {
              LOG.log(Level.INFO, "The server was not able to process the event: {0}", new Object[]{response.getStatus() + " " + response.getStatusInfo()});
            } else {
              expectedState.logEventIntoApplication(eventdto);
            }
          }
        };
        executor.execute(task);
      }
    }

    LOG.log(Level.INFO, "All tasks have been submitted to the executor and will be processed by {0} concurrent threads.", numberOfConcurrentThreads);
    try {
      executor.shutdown();
      executor.awaitTermination(1, TimeUnit.HOURS);
      LOG.log(Level.INFO, "Number of responses received: {0}", numberOfResponses);
      LOG.log(Level.INFO, "Expected state: {0}", expectedState);
      List<String> errors = validateExpectedAgainstActualState();
      LOG.info("Errors: " + errors.toString());

    } catch (InterruptedException ex) {
      Logger.getLogger(ConcurrentUpdateGamificationClient.class.getName()).log(Level.SEVERE, null, ex);
    }
    LOG.info("Done.");

  }
  
  private List<String> validateExpectedAgainstActualState() {

    List<String> errors = new ArrayList<>();
    
    List<EndUserDTO> actualState = getEndsUsersListFromServer(APIKEYFORTEST);
    LOG.log(Level.INFO, "Expected number of endUsers: {0}", expectedState.getApplicationEndUsers(APIKEYFORTEST).size());
    LOG.log(Level.INFO, "Actual number of endUsers: {0}", actualState.size());
    if (expectedState.getApplicationEndUsers(APIKEYFORTEST).size() != actualState.size()) {
      errors.add("The number of endUsers on the server is not the one expected: " + actualState.size() + " vs " + expectedState.getApplicationEndUsers(APIKEYFORTEST).size());
    }
 
    return errors;

  }

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    System.setProperty("java.util.logging.SimpleFormatter.format", "%1$tH:%1$tM:%1$tS %4$s %5$s%6$s%n");
    
    ConcurrentUpdateGamificationClient client = new ConcurrentUpdateGamificationClient();
    client.test();
  }

}
