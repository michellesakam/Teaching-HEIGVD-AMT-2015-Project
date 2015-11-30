package ch.heigvd.amt.gamification.dto;
import java.util.HashMap;

/**
 *
 * @author Raphaël Racine
 */
public class RuleDTO implements IGamificationDTO {

    private Long ruleID;
    
    private HashMap conditionsToApply;
    private String eventType;
    
    private String reason;
    
    private String awardType; // awardBadge or awardPoint
    private Long nbPoints; // If awardPoint
    private Long badgeID; // If awardBadge

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

    public Long getNbPoints() {
        return nbPoints;
    }

    public void setNbPoints(Long nbPoints) {
        this.nbPoints = nbPoints;
    }

    public Long getBadgeID() {
        return badgeID;
    }

    public void setBadgeID(Long badgeID) {
        this.badgeID = badgeID;
    }
        
    
}
