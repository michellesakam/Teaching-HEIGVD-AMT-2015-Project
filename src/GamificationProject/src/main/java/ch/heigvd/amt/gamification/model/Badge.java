package ch.heigvd.amt.gamification.model;


import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 *
 * @author Raphaël Racine
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Badge.findByApplication", 
            query = "SELECT b FROM Badge b WHERE b.application = :application")
})
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


