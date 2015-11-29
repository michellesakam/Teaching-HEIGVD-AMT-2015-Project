
package ch.heigvd.amt.gamification.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
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
    
    @OneToOne(cascade = CascadeType.ALL)
    private Action action;
    
    private String eventType;

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

    public Action getAction() {
        return action;
    }

    public void setAction(Action action) {
        this.action = action;
    }    
    
}
