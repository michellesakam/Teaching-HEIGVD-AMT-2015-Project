package ch.heigvd.amt.gamification.model;

import java.util.HashMap;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public abstract class Action extends AbstractDomainModelEntity<Long> {
    
    private String reason;    
    private HashMap<String, Object> conditionsToApply = new HashMap<>();

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public HashMap getConditionsToApply() {
        return conditionsToApply;
    }

    public void setConditionsToApply(HashMap conditionsToApply) {
        this.conditionsToApply = conditionsToApply;
    }    
    
}
