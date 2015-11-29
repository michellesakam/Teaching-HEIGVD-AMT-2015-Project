package ch.heigvd.amt.gamification.services;

import ch.heigvd.amt.gamification.services.passwordvalidation.BadPasswordException;
import ch.heigvd.amt.gamification.model.Account;
import ch.heigvd.amt.gamification.model.ActionAwardBadge;
import ch.heigvd.amt.gamification.model.ActionAwardPoints;
import ch.heigvd.amt.gamification.model.Application;
import ch.heigvd.amt.gamification.model.Badge;
import ch.heigvd.amt.gamification.model.EndUser;
import ch.heigvd.amt.gamification.model.Rule;
import ch.heigvd.amt.gamification.model.Level;

import ch.heigvd.amt.gamification.util.Chance;
import java.sql.Date;
import java.util.logging.Logger;
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

    @EJB
    private LevelsManagerLocal levelsManager;
    
    @Override
    public void generateTestData() {

        String password = "toortoor";
        String firstName;
        String lastName;

        /* Create a list of accounts */
        for (int i = 0; i < 50; ++i) {
            Account a = new Account();
            lastName = Chance.randomLastName();
            firstName = Chance.randomFirstName();
            a.setEmail(firstName + "." + lastName + i + "@google.ch");
            a.setPassword(password);
            a.setFirstName(firstName);
            a.setLastName(lastName);
            try {
                accountsManager.createAccount(a);
            } catch (BadPasswordException ex) {
                Logger.getLogger(TestDataManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
        }

        Account constantAccount = new Account();
        constantAccount.setEmail("raphael.racine@heig-vd.ch");
        constantAccount.setPassword(password);
        constantAccount.setFirstName("Raphaël");
        constantAccount.setLastName("Racine");
        try {
            accountsManager.createAccount(constantAccount);
        } catch (BadPasswordException ex) {
            Logger.getLogger(TestDataManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        /* Create a first application */
        Application app1 = new Application();
        app1.setIsEnable(true);
        app1.setName("Battlefield 3");
        app1.setDescription("Devenez le meilleur soldat !");

        applicationsManager.assignApplicationToAccount(app1, constantAccount);

        Application app2 = new Application();
        app2.setIsEnable(false);
        app2.setName("The Elder Scroll's 5 : Skyrim");
        app2.setDescription("Tuez votre cheval !");

        applicationsManager.assignApplicationToAccount(app2, constantAccount);

        Account createur2 = new Account();
        createur2.setEmail("olivier.liechti@heig-vd.ch");
        createur2.setPassword(password);
        createur2.setFirstName("Olivier");
        createur2.setLastName("Liechti");
        try {
            accountsManager.createAccount(createur2);
        } catch (BadPasswordException ex) {
            Logger.getLogger(TestDataManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        Application app3 = new Application();
        app3.setIsEnable(true);
        app3.setName("Google Chrome");
        app3.setDescription("Surfez sur Internet !");

        applicationsManager.assignApplicationToAccount(app3, createur2);

        /* Associate EndUsers to an application */
        EndUser user1 = new EndUser();
        user1.setRegDate(new Date(System.currentTimeMillis()));
        user1.setUserID("UK1928J28k");

        EndUser user2 = new EndUser();
        user2.setRegDate(new Date(2015, 1, 25));
        user2.setUserID("PKZ927J28k");

        EndUser user3 = new EndUser();
        user3.setRegDate(new Date(System.currentTimeMillis()));
        user3.setUserID("FJFKDJFFSD5f");

        applicationsManager.assignApplicationToAnEndUser(app1, user1);
        applicationsManager.assignApplicationToAnEndUser(app1, user2);
        applicationsManager.assignApplicationToAnEndUser(app3, user3);

        for (int i = 0; i < 3; ++i) {
            EndUser user = new EndUser();
            user.setRegDate(new Date(System.currentTimeMillis()));
            user.setUserID("GaGAee23" + i);

            applicationsManager.assignApplicationToAnEndUser(app1, user);
        }
        
        // Create some badges in app1
        Badge badge = new Badge();
        badge.setName("badge1");
        applicationsManager.assignBadgeToAnApplication(app1, badge);
        
        badge = new Badge();
        badge.setName("badge2");
        applicationsManager.assignBadgeToAnApplication(app1, badge);
        
        badge = new Badge();
        badge.setName("badge3");
        applicationsManager.assignBadgeToAnApplication(app1, badge);
        
        // Add some rules to applications for gamification
        Rule rule = new Rule();
        ActionAwardPoints actionAwardPoints = new ActionAwardPoints();
        actionAwardPoints.setNbPoints(2);
        actionAwardPoints.setReason("Posted a comment");
        rule.setEventType("comment");
        rule.setAction(actionAwardPoints);
        applicationsManager.assignRuleToAnApplication(app1, rule);
        
        rule = new Rule();
        rule.setEventType("comment");
        ActionAwardBadge actionAwardBadge = new ActionAwardBadge();
        actionAwardBadge.setBadge(badge);
        actionAwardBadge.setReason("Posted a comment");
        actionAwardBadge.getConditionsToApply().put("nbComments", 100);
        rule.setAction(actionAwardBadge);
        applicationsManager.assignRuleToAnApplication(app1, rule);
        
        rule = new Rule();
        rule.setEventType("addQuestion");
        actionAwardPoints = new ActionAwardPoints();
        actionAwardPoints.setNbPoints(5);
        actionAwardPoints.setReason("Added a question");
        rule.setAction(actionAwardPoints);
        applicationsManager.assignRuleToAnApplication(app1, rule);
        
        app1.getApiKey().setKey("ABC-123");
        
        // Create some levels in app1
        Level level = new Level();
        level.setName("Soldat");
        level.setMinimumPoints(0);
        levelsManager.assignLevelToApplication(app1, level);
        
        level = new Level();
        level.setName("Sergent");
        level.setMinimumPoints(20);
        levelsManager.assignLevelToApplication(app1, level);
        
        level = new Level();
        level.setName("Lieutnant");
        level.setMinimumPoints(200);
        levelsManager.assignLevelToApplication(app1, level);
        
        level = new Level();
        level.setName("General");
        level.setMinimumPoints(500);
        levelsManager.assignLevelToApplication(app1, level);        
        
    }

}
