package ch.heigvd.amt.gamification.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 *
 * @author michelle meguep
 */
@Entity
@DiscriminatorValue("score")

@NamedQueries({
    @NamedQuery(name = "AwardPoint.getNumberOfPoints",
            query = "SELECT SUM(aw.nbPoints) FROM AwardPoint aw "
            + "WHERE aw.endUser = :endUser AND aw.endUser.application = :application"),
    @NamedQuery(name = "AwardPoint.getPointsPerMonthInAYear",
            query = "SELECT FUNCTION('MONTH', aw.dateReception), SUM(aw.nbPoints) FROM AwardPoint aw "
                    + "WHERE FUNCTION('YEAR', aw.dateReception) = :year AND aw.endUser = :endUser "
                    + "AND aw.endUser.application = :application"
                    + " GROUP BY FUNCTION('MONTH', aw.dateReception)")

})
public class AwardPoint extends Award {

    private int nbPoints;

    public AwardPoint() {

    }

    public int getNbPoints() {
        return nbPoints;
    }

    public void setNbPoints(int nbPoints) {
        this.nbPoints = nbPoints;
    }

}
