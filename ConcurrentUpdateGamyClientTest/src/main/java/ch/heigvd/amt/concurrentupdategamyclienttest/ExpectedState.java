package ch.heigvd.amt.concurrentupdategamyclienttest;

import ch.heigvd.amt.gamification.client.dto.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author michelle meguep
 */
public class ExpectedState {

    private static final Map<String, EndUserDTO> endUsers = new HashMap<>();
    private static final Map<String, ApplicationEndUsersDTO> applications = new HashMap<>();

    public synchronized void logEventIntoApplication(EventDTO event, String apiKey) {
        ApplicationEndUsersDTO application = applications.get(apiKey);
        if (application == null) {
            application = new ApplicationEndUsersDTO();
            application.setNbEndUsers(1);
            applications.put(apiKey, application);
        } else {
            application.setNbEndUsers(application.getNbEndUsers() + 1);
        }
        EndUserDTO enduser = endUsers.get(event.getEndUserNumber());

        if (enduser == null) {
            enduser = new EndUserDTO();
            enduser.setEndUserNumber(event.getEndUserNumber());
            enduser.setApikey(apiKey);
            endUsers.put(event.getEndUserNumber(), enduser);
        }

        enduser.setNbPoints(enduser.getNbPoints() + 2);
        if (event.getProperties().get("nbComments").equals(100)) {
            BadgeDTO b = new BadgeDTO();
            b.setName("badge3");
            enduser.getBadges().add(b);
            enduser.setNbBadges(enduser.getNbBadges() + 1);
        }

        application.setEndUsers(enduser);
    }

    public List<EndUserDTO> getApplicationEndUsers(String apikey) {
        return applications.get(apikey).getEndUsers();
    }

}
