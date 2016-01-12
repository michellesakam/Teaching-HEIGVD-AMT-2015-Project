package ch.heigvd.amt.gamification.services;

import ch.heigvd.amt.gamification.model.Application;
import ch.heigvd.amt.gamification.model.Rule;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import javax.ejb.EJB;
import javax.ejb.Singleton;

/**
 *
 * @author Raphaël Racine
 */
@Singleton
public class RulesCache implements RulesCacheLocal {
    
    @EJB
    private RulesManagerLocal rulesManager;
    
    private static Map<RuleCacheKey, List<Rule>> rulesCache = new HashMap<>();

    private void loadAllRules() {
        
        List<Rule> rules = rulesManager.findAll();
        
        for(Rule r : rules) {
            RuleCacheKey key = new RuleCacheKey(r.getApplication().getId(), r.getEventType());

            if(!rulesCache.containsKey(key)) {
                rulesCache.put(key, new LinkedList<Rule>());
            }

            rulesCache.get(key).add(r);
        }
        
    }
    
    @Override
    public List<Rule> loadRuleFromCache(Application application, String eventType) {
        
        List<Rule> rules;
        
        if(rulesCache.isEmpty()) {
            loadAllRules();
        }
        
        rules = rulesCache.get(new RuleCacheKey(application.getId(), eventType));
        
        return rules == null ? new LinkedList<Rule>() : rules;
    }   

    @Override
    public void clearCache() {
        rulesCache.clear();
    }
    
}

class RuleCacheKey {
    private final long idApplication;
    private final String eventType;

    public RuleCacheKey(long idApplication, String eventType) {
        this.idApplication = idApplication;
        this.eventType = eventType;
    }   
    
    public long getIdApplication() {
        return idApplication;
    }

    public String getEventType() {
        return eventType;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 19 * hash + (int) (this.idApplication ^ (this.idApplication >>> 32));
        hash = 19 * hash + Objects.hashCode(this.eventType);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final RuleCacheKey other = (RuleCacheKey) obj;
        if (this.idApplication != other.idApplication) {
            return false;
        }
        if (!Objects.equals(this.eventType, other.eventType)) {
            return false;
        }
        return true;
    }
    
        
    
}
