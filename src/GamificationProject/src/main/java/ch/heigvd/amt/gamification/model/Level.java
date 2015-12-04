package ch.heigvd.amt.gamification.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Raphaël Racine
 */
@NamedQueries({
    @NamedQuery(name = "Level.findByApiKey",
            query = "SELECT l FROM Level l WHERE l.application.apiKey.key = :apikey"),
    @NamedQuery(name = "Level.findCurrentLevel",
            query = "SELECT l FROM Level l WHERE l.application = :application AND l.minimumPoints <= :nbPoints ORDER BY l.minimumPoints DESC"),
    @NamedQuery(name = "Level.findNextLevel",
            query = "SELECT l FROM Level l WHERE l.application = :application AND l.minimumPoints > :nbPoints ORDER BY l.minimumPoints ASC")
})

@Entity
@Table(name = "Levels") // Changing the name of tale because Level is a key work of mysql
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
