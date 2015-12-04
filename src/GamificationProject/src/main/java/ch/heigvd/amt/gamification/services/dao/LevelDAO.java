package ch.heigvd.amt.gamification.services.dao;

import ch.heigvd.amt.gamification.model.Application;
import ch.heigvd.amt.gamification.model.Level;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * This SLSB implements the DAO design pattern. This class implements the data
 * access for the Company JPA entity. It extends the GenericDAO and with
 * <Company, Long>, it declares that manages Company entities, which have a Long
 * primary key.
 *
 * @author Olivier Liechti (olivier.liechti@heig-vd.ch) Edit : Parfait Noubissi
 * (parfait.noubissi@heig-vd.ch)
 */
@Stateless
public class LevelDAO extends GenericDAO<Level, Long> implements LevelDAOLocal {

    @Override
    public List<Level> findLevelsByApiKey(String apikey) {
        return em.createNamedQuery("Level.findByApiKey")
                .setParameter("apikey", apikey)
                .getResultList();
    }

    @Override
    public Level findCurrentLevel(Application app, long nbPointsEndUser) {
        try {
            return (Level) em.createNamedQuery("Level.findCurrentLevel")
                    .setParameter("nbPoints", nbPointsEndUser)
                    .setParameter("application", app)
                    .setMaxResults(1)
                    .getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public Level findNextLevel(Application app, long nbPointsEndUser) {
        try {
            return (Level) em.createNamedQuery("Level.findNextLevel")
                    .setParameter("nbPoints", nbPointsEndUser)
                    .setParameter("application", app)
                    .setMaxResults(1)
                    .getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }

}
