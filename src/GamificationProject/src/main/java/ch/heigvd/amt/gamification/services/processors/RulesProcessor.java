package ch.heigvd.amt.gamification.services.processors;

import ch.heigvd.amt.gamification.dto.RuleDTO;
import ch.heigvd.amt.gamification.model.Action;
import ch.heigvd.amt.gamification.model.ActionAwardBadge;
import ch.heigvd.amt.gamification.model.ActionAwardPoints;
import ch.heigvd.amt.gamification.model.Application;
import ch.heigvd.amt.gamification.model.Badge;
import ch.heigvd.amt.gamification.model.Rule;
import ch.heigvd.amt.gamification.services.ApplicationsManagerLocal;
import ch.heigvd.amt.gamification.services.BadgesManagerLocal;
import ch.heigvd.amt.gamification.services.RulesManagerLocal;
import ch.heigvd.amt.gamification.services.dao.GamificationDomainEntityNotFoundException;
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
    private BadgesManagerLocal badgesManager;
    
    @EJB
    private RulesManagerLocal rulesManager;

    @Override
    public void postDTO(String apiKey, RuleDTO dto) {
        Application application = super.tryToRetrieveApplication(apiKey);

        Rule rule = new Rule();
        Action action = null;

        switch (dto.getAwardType()) {

            case "AwardBadge":
                ActionAwardBadge actionAwardBadge;
                actionAwardBadge = new ActionAwardBadge();

                Badge badge;
                try {
                    badge = badgesManager.findById((Long) dto.getAwardValue());
                } catch (GamificationDomainEntityNotFoundException ex) {
                    throw new Error("This badge doesnt exists");
                }

                actionAwardBadge.setBadge(badge);
                action = actionAwardBadge;
                break;

            case "AwardPoints":

                ActionAwardPoints actionAwardPoints;
                actionAwardPoints = new ActionAwardPoints();
                actionAwardPoints.setNbPoints((int) dto.getAwardValue());
                action = actionAwardPoints;
                break;

        }

        rule.setConditionsToApply(dto.getConditionsToApply());
        rule.setReason(dto.getReason());

        rule.setAction(action);

        rule.setEventType(dto.getEventType());

        rulesManager.assignRuleToAnApplication(application, rule);
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
