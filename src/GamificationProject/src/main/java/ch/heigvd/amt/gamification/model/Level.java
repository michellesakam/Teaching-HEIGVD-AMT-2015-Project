package ch.heigvd.amt.gamification.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/**
 *
 * @author Raphaël Racine
 */
@Entity
public class Level extends AbstractDomainModelEntity<Long> {
    
    @ManyToOne
    private Application application;
    
    private String name;
    private int minimumPoints;

    public Application getApplication() {
        return application;
    }

    public void setApplication(Application application) {
        this.application = application;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMinimumPoints() {
        return minimumPoints;
    }

    public void setMinimumPoints(int minimumPoints) {
        this.minimumPoints = minimumPoints;
    }
    
    
}
