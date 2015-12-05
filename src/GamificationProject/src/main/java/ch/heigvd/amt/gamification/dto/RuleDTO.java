package ch.heigvd.amt.gamification.dto;
import java.util.HashMap;

/**
 *
 * @author Raphaël Racine
 * @param <T>
 */
public class RuleDTO<T> implements IGamificationDTO {

    private Long ruleID;
    
    private HashMap conditionsToApply;
    private String eventType;
    
    private String reason;
    
    private String awardType; // awardBadge or awardPoint
    private T awardValue;

    public Long getRuleID() {
        return ruleID;
    }

    public void setRuleID(Long ruleID) {
        this.ruleID = ruleID;
    }

    public HashMap getConditionsToApply() {
        return conditionsToApply;
    }

    public void setConditionsToApply(HashMap conditionsToApply) {
        this.conditionsToApply = conditionsToApply;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public String getAwardType() {
        return awardType;
    }

    public void setAwardType(String awardType) {
        this.awardType = awardType;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public T getAwardValue() {
        return awardValue;
    }

    public void setAwardValue(T awardValue) {
        this.awardValue = awardValue;
    }            
    
}
