package ch.heigvd.amt.gamification.services;

import ch.heigvd.amt.gamification.dto.EventDTO;
import ch.heigvd.amt.gamification.model.Action;
import ch.heigvd.amt.gamification.model.ActionAwardBadge;
import ch.heigvd.amt.gamification.model.ActionAwardPoints;
import ch.heigvd.amt.gamification.model.Application;
import ch.heigvd.amt.gamification.model.AwardBadge;
import ch.heigvd.amt.gamification.model.AwardPoint;
import ch.heigvd.amt.gamification.model.EndUser;
import ch.heigvd.amt.gamification.model.Rule;
import ch.heigvd.amt.gamification.services.dao.AwardDAOLocal;
import ch.heigvd.amt.gamification.services.dao.RuleDAOLocal;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Raphaël Racine
 */
@Stateless
public class RulesManager implements RulesManagerLocal {

    @EJB
    private RuleDAOLocal ruleDAO;

    @EJB
    private AwardDAOLocal awardDAO;

    @Override
    public List<Rule> findByEventTypeAndApplication(Application application, String eventType) {
        return ruleDAO.findByEventTypeAndApplication(application, eventType);
    }

    @Override
    public List<Rule> findByApiKey(String apiKey) {
        return ruleDAO.findByApiKey(apiKey);
    }

    @Override
    public void processRuleForAnEvent(EventDTO eventDTO, Rule r, EndUser endUser) {

        Action action = r.getAction();

        Map<String, Object> conditionsToApply = r.getConditionsToApply();

        for (String key : conditionsToApply.keySet()) {

            if (eventDTO.getProperty(key) == null) {
                return;
            }

            if (!(eventDTO.getProperty(key).equals(conditionsToApply.get(key)))) {
                return;
            }
        }

        if (action.getClass() == ActionAwardBadge.class) {

            ActionAwardBadge actionAwardBadge = (ActionAwardBadge) action;

            AwardBadge awardBadge = new AwardBadge();
            awardBadge.setBadge(actionAwardBadge.getBadge());
            awardBadge.setReceptionDate(eventDTO.getTimestamp());
            awardBadge.setEndUser(endUser);
            awardBadge.setReason(r.getReason());

            awardDAO.create(awardBadge);
        } else if (action.getClass() == ActionAwardPoints.class) {
            ActionAwardPoints actionAwardPoints = (ActionAwardPoints) action;

            AwardPoint awardPoint = new AwardPoint();
            awardPoint.setReceptionDate(eventDTO.getTimestamp());
            awardPoint.setEndUser(endUser);
            awardPoint.setReason(r.getReason());
            awardPoint.setNbPoints((int) actionAwardPoints.getNbPoints());

            awardDAO.create(awardPoint);
        }
    }
    
    @Override
    public void assignRuleToAnApplication(Application application, Rule rule) {
        ruleDAO.assignRuleToAnApplication(application, rule);
    }

}
