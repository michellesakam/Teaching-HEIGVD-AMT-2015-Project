package ch.heigvd.amt.gamification.services.dao;

import ch.heigvd.amt.gamification.model.Application;
import ch.heigvd.amt.gamification.model.Badge;
import ch.heigvd.amt.gamification.model.EndUser;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author Samira
 */
@Stateless
public class BadgeDAO extends GenericDAO<Badge, Long> implements BadgeDAOLocal {

    @Override
    public List<Badge> findByApiKey(String apiKey) {
        return em.createNamedQuery("Badge.findByApiKey")
                .setParameter("apiKey", apiKey)
                .getResultList();
    }

    @Override
    public List<Badge> findByEndUser(EndUser endUser, Application application) {
        return em.createNamedQuery("AwardBadge.findByEndUserAndApplication")
                .setParameter("application", application)
                .setParameter("endUser", endUser)
                .getResultList();
    }
    
    
    
}
