package ch.heigvd.amt.gamification.model;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/**
 *
 * @author Raphaël Racine
 */
@Entity
public class Badge extends AbstractDomainModelEntity<Long> {
    
    @ManyToOne
    private Application application;
    
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Application getApplication() {
        return application;
    }

    public void setApplication(Application application) {
        this.application = application;
    }  
    
    
    
    
    
}

