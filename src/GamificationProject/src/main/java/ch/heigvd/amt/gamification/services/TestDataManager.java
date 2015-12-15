package ch.heigvd.amt.gamification.services;

import ch.heigvd.amt.gamification.services.passwordvalidation.BadPasswordException;
import ch.heigvd.amt.gamification.model.Account;
import ch.heigvd.amt.gamification.model.ActionAwardBadge;
import ch.heigvd.amt.gamification.model.ActionAwardPoints;
import ch.heigvd.amt.gamification.model.Application;
import ch.heigvd.amt.gamification.model.Badge;
import ch.heigvd.amt.gamification.model.Rule;
import ch.heigvd.amt.gamification.model.Level;
import ch.heigvd.amt.gamification.services.processors.EventsProcessorLocal;

import ch.heigvd.amt.gamification.util.Chance;
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

    @EJB
    private BadgesManagerLocal badgesManager;

    @EJB
    private RulesManagerLocal rulesManager;

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
        app1.getApiKey().setKey("ABC-123");

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

        // Create some badges in app1
        Badge badge1 = new Badge();
        badge1.setName("badge1");
        badgesManager.assignBadgeToAnApplication(app1, badge1);

        Badge badge2 = new Badge();
        badge2.setName("badge2");
        badgesManager.assignBadgeToAnApplication(app1, badge2);

        Badge badge3 = new Badge();
        badge3.setName("badge3");
        badgesManager.assignBadgeToAnApplication(app1, badge3);

        Badge badgeWarrior = new Badge();
        badgeWarrior.setName("Warrior");
        badgesManager.assignBadgeToAnApplication(app1, badgeWarrior);

        // Add some rules to applications for gamification
        ActionAwardPoints actionAwardPoints;
        Rule rule = new Rule();
        for (int i = 0; i < 100; i++) {
            rule = new Rule();
            actionAwardPoints = new ActionAwardPoints();
            actionAwardPoints.setNbPoints(2);
            rule.setReason("Posted a comment");
            rule.setEventType("comment");
            rule.setAction(actionAwardPoints);
            rulesManager.assignRuleToAnApplication(app1, rule);
        }

        rule = new Rule();
        rule.setEventType("comment");
        ActionAwardBadge actionAwardBadge = new ActionAwardBadge();
        actionAwardBadge.setBadge(badge3);
        rule.setReason("Posted 100 comments");
        rule.getConditionsToApply().put("nbComments", 100);
        rule.setAction(actionAwardBadge);
        rulesManager.assignRuleToAnApplication(app1, rule);

        rule = new Rule();
        rule.setEventType("addQuestion");
        actionAwardPoints = new ActionAwardPoints();
        actionAwardPoints.setNbPoints(5);
        rule.setReason("Added a question");
        rule.setAction(actionAwardPoints);
        rulesManager.assignRuleToAnApplication(app1, rule);

        rule = new Rule();
        rule.setEventType("addQuestion");
        actionAwardBadge = new ActionAwardBadge();
        actionAwardBadge.setBadge(badgeWarrior);
        rule.setReason("Posted 100 questions");
        rule.getConditionsToApply().put("nbQuestions", 100);
        rule.setAction(actionAwardBadge);
        rulesManager.assignRuleToAnApplication(app1, rule);

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
