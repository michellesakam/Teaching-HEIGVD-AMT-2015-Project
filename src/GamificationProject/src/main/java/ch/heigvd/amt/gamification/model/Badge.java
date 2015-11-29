package ch.heigvd.amt.gamification.model;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author Raphaël Racine
 */
@Entity
public class Badge extends AbstractDomainModelEntity<Long> {
    
    @OneToMany(mappedBy = "badge")
    private List<AwardBadge> awardBadges;
    
    @ManyToOne
    private Application application;
    
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<AwardBadge> getAwardBadges() {
        return awardBadges;
    }

    public void setAwardBadges(List<AwardBadge> awardBadges) {
        this.awardBadges = awardBadges;
    }

    public Application getApplication() {
        return application;
    }

    public void setApplication(Application application) {
        this.application = application;
    }  
    
    
    
    
    
}

