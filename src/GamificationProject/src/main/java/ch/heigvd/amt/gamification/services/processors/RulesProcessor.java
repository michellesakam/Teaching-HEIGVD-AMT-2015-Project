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
public class RulesProcessor extends GamificationDTOProcessor<RuleDTO, Long>
        implements RulesProcessorLocal {

    @EJB
    private ApplicationsManagerLocal applicationsManager;

    @Override
    public void postDTO(String apiKey, RuleDTO dto) {
        Application application = super.tryToRetrieveApplication(apiKey);

        Rule rule = new Rule();
        Action action = null;

        switch (dto.getAwardType()) {
            
            case "AwardBadge":
                ActionAwardBadge actionAwardBadge;
                actionAwardBadge = new ActionAwardBadge();

                Badge badge = applicationsManager.findBadgeByIdAndApiKey((Long) dto.getAwardValue(), apiKey);

                if (badge == null)
                    throw new NullPointerException("This badge doesnt exists");

                actionAwardBadge.setBadge(badge);
                actionAwardBadge.setReason(dto.getReason());
                actionAwardBadge.setConditionsToApply(dto.getConditionsToApply());
                action = actionAwardBadge;
                break;
                
            case "AwardPoints":
                
                ActionAwardPoints actionAwardPoints;
                actionAwardPoints = new ActionAwardPoints();
                actionAwardPoints.setConditionsToApply(dto.getConditionsToApply());
                actionAwardPoints.setReason(dto.getReason());
                actionAwardPoints.setNbPoints((int) dto.getAwardValue());
                action = actionAwardPoints;
                break;
                
        }

        if (action != null) {
            action.setConditionsToApply(dto.getConditionsToApply());
            action.setReason(dto.getReason());
        } else {
            throw new Error("The action specified for this rule is not valid");
        }

        rule.setAction(action);

        rule.setEventType(dto.getEventType());

        applicationsManager.assignRuleToAnApplication(application, rule);
    }

    @Override
    public void putDTO(String apiKey, Long id, RuleDTO dto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteDTO(Long id, String apiKey) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
