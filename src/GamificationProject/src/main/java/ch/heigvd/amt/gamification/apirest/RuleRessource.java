package ch.heigvd.amt.gamification.apirest;

import ch.heigvd.amt.gamification.dto.RuleDTO;
import ch.heigvd.amt.gamification.model.Action;
import ch.heigvd.amt.gamification.model.ActionAwardBadge;
import ch.heigvd.amt.gamification.model.ActionAwardPoints;
import ch.heigvd.amt.gamification.model.Application;
import ch.heigvd.amt.gamification.model.Badge;
import ch.heigvd.amt.gamification.model.Rule;
import ch.heigvd.amt.gamification.services.ApplicationsManagerLocal;
import ch.heigvd.amt.gamification.services.RulesManagerLocal;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 *
 * @author Raphaël Racine
 */
@Stateless
@Path("rules")
public class RuleRessource {

    @EJB
    private RulesManagerLocal rulesManager;
    
    @EJB
    private ApplicationsManagerLocal applicationsManager;
    
    @GET
    @Produces("application/json")
    public List<RuleDTO> getRules(String apiKey) {
        List<RuleDTO> dto = new ArrayList<>();
        List<Rule> rules = rulesManager.findByApiKey(apiKey);

        for (Rule rule : rules) {
            dto.add(toDTO(rule));
        }
        
        return dto;
    }

    @POST
    @Consumes("application/json")
    public void postRule(RuleDTO ruleDTO) {

        Application application = applicationsManager.retrieveApplicationByApikey(ruleDTO.getApiKey());

        if (application == null) {
            throw new NullPointerException("This application doesn't exists");
        }

        Rule rule = new Rule();
        Action action = null;
        
        switch(ruleDTO.getAwardType()) {
            case "AwardBadge":
                ActionAwardBadge actionAwardBadge;
                actionAwardBadge = new ActionAwardBadge();
                
                Badge badge = applicationsManager.findBadgeByIdAndApiKey(ruleDTO.getBadgeID(), ruleDTO.getApiKey());
                
                if(badge == null)
                    throw new NullPointerException("This badge doesnt exists");
                
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
        
        if(action != null) {
            action.setConditionsToApply(ruleDTO.getConditionsToApply());
            action.setReason(ruleDTO.getReason());
        }
        else
            throw new Error("The action specified for this rule is not valid");
        
        rule.setAction(action);
        
        rule.setEventType(ruleDTO.getEventType());
                
        applicationsManager.assignRuleToAnApplication(application, rule);
    }

    @PUT
    @Consumes("application/json")
    public void putRule(@PathParam(value = "ruleID") Long ruleID, RuleDTO ruleDTO) {
        // TODO:
    }

    @DELETE
    @Consumes("application/json")
    public void deleteRule(@PathParam(value = "ruleID") Long ruleID, String apiKey) {
        // TODO:
    }

    public RuleDTO toDTO(Rule rule) {

        RuleDTO dto = new RuleDTO();
        
        dto.setRuleID(rule.getId());
        dto.setConditionsToApply(rule.getAction().getConditionsToApply());
        dto.setEventType(rule.getEventType());
        
        dto.setBadgeID((Long) rule.getAction().getValue());
        dto.setNbPoints(Integer.SIZE);
        
        dto.setAwardType(rule.getAction().getType());
        dto.setApiKey(rule.getApplication().getApiKey().getKey());

        return dto;
    }

}
