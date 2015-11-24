
package ch.heigvd.amt.gamification.model;

import java.util.HashMap;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/**
 *
 * @author Samira
 */
@Entity
public class Rule extends AbstractDomainModelEntity<Long> {
       
    private String typeEvenement;
    
    @ManyToOne
    private Application application;
    
    private HashMap<String, Object> defaultActions;

    public Rule() {
    }

    public String getTypeEvenement() {
        return typeEvenement;
    }

    public void setTypeEvenement(String typeEvenement) {
        this.typeEvenement = typeEvenement;
    }

    public Application getApplication() {
        return application;
    }

    public void setApplication(Application application) {
        this.application = application;
    }

    public HashMap<String, Object> getDefaultActions() {
        return defaultActions;
    }

    public void setDefaultActions(HashMap<String, Object> defaultActions) {
        this.defaultActions = defaultActions;
    }
    
    
    
    
}
