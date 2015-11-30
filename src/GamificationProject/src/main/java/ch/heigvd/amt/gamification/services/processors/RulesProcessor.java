package ch.heigvd.amt.gamification.services.processors;

import ch.heigvd.amt.gamification.dto.RuleDTO;
import ch.heigvd.amt.gamification.model.Action;
import ch.heigvd.amt.gamification.model.ActionAwardBadge;
import ch.heigvd.amt.gamification.model.ActionAwardPoints;
import ch.heigvd.amt.gamification.model.Application;
import ch.heigvd.amt.gamification.model.Badge;
import ch.heigvd.amt.gamification.model.Rule;
import ch.heigvd.amt.gamification.services.ApplicationsManagerLocal;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Raphaël Racine
 */
@Stateless
public class RulesProcessor extends GamificationDTOProcessor implements RulesProcessorLocal {

    @EJB
    private ApplicationsManagerLocal applicationsManager;

    @Override
    public void processPostRule(RuleDTO ruleDTO) {
        Application application = super.tryToRetrieveApplication(ruleDTO.getApiKey());

        Rule rule = new Rule();
        Action action = null;

        switch (ruleDTO.getAwardType()) {
            case "AwardBadge":
                ActionAwardBadge actionAwardBadge;
                actionAwardBadge = new ActionAwardBadge();

                Badge badge = applicationsManager.findBadgeByIdAndApiKey(ruleDTO.getBadgeID(), ruleDTO.getApiKey());

                if (badge == null) {
                    throw new NullPointerException("This badge doesnt exists");
                }

                actionAwardBadge.setBadge(badge);
                actionAwardBadge.setReason(ruleDTO.getReason());
                actionAwardBadge.setConditionsToApply(ruleDTO.getConditionsToApply());
                action = actionAwardBadge;
                break;
            case "AwardPoints":
                ActionAwardPoints actionAwardPoints;
                actionAwardPoints = new ActionAwardPoints();
                actionAwardPoints.setConditionsToApply(ruleDTO.getConditionsToApply());
                actionAwardPoints.setReason(ruleDTO.getReason());
                actionAwardPoints.setNbPoints(ruleDTO.getNbPoints());
                action = actionAwardPoints;
                break;
        }

        if (action != null) {
            action.setConditionsToApply(ruleDTO.getConditionsToApply());
            action.setReason(ruleDTO.getReason());
        } else {
            throw new Error("The action specified for this rule is not valid");
        }

        rule.setAction(action);

        rule.setEventType(ruleDTO.getEventType());

        applicationsManager.assignRuleToAnApplication(application, rule);
    }

}
