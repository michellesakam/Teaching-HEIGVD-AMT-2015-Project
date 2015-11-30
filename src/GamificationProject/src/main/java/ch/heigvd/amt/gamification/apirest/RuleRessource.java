package ch.heigvd.amt.gamification.apirest;

import ch.heigvd.amt.gamification.dto.RuleDTO;
import ch.heigvd.amt.gamification.model.Rule;
import ch.heigvd.amt.gamification.services.ApplicationsManagerLocal;
import ch.heigvd.amt.gamification.services.RulesManagerLocal;
import ch.heigvd.amt.gamification.services.processors.RulesProcessorLocal;
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
    private RulesProcessorLocal rulesProcessor;
    
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
        rulesProcessor.postDTO(ruleDTO);
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
