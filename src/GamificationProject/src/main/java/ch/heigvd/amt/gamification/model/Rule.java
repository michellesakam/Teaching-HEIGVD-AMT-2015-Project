
package ch.heigvd.amt.gamification.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
/**
 *
 * @author Samira
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Rule.findByEventTypeAndApplication", 
            query = "SELECT r FROM Rule r WHERE r.application = :application AND r.eventType = :eventType")
})
public class Rule extends AbstractDomainModelEntity<Long> {
    
    @ManyToOne
    private Application application;
    
    private String eventType;
    
    private String actionType;

    public Application getApplication() {
        return application;
    }

    public void setApplication(Application application) {
        this.application = application;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public String getActionType() {
        return actionType;
    }

    public void setActionType(String actionType) {
        this.actionType = actionType;
    }
    
    
    
}
