package ch.heigvd.amt.gamification.services.dao;

import ch.heigvd.amt.gamification.model.Badge;
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
    
}
