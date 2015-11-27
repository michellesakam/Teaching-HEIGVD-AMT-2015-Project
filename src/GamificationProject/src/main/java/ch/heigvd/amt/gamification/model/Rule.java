
package ch.heigvd.amt.gamification.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
/**
 *
 * @author Samira
 */
@Entity
public class Rule extends AbstractDomainModelEntity<Long> {
    
    @ManyToOne
    private Application application;
    
    private String typeEvenement;
    
    private String typeAction;

    public Application getApplication() {
        return application;
    }

    public void setApplication(Application application) {
        this.application = application;
    }

    public String getTypeEvenement() {
        return typeEvenement;
    }

    public void setTypeEvenement(String typeEvenement) {
        this.typeEvenement = typeEvenement;
    }

    public String getTypeAction() {
        return typeAction;
    }

    public void setTypeAction(String typeAction) {
        this.typeAction = typeAction;
    }
    
    
    
}
