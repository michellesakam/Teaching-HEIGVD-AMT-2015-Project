package ch.heigvd.amt.gamification.services;

import ch.heigvd.amt.gamification.model.Badge;
import ch.heigvd.amt.gamification.services.dao.BadgeDAOLocal;
import ch.heigvd.amt.gamification.services.dao.GamificationDomainEntityNotFoundException;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Raphaël Racine
 */
@Stateless
public class BadgesManager implements BadgesManagerLocal {
    
    @EJB
    private BadgeDAOLocal badgeDAO;

    @Override
    public void editBadge(Badge badge) throws GamificationDomainEntityNotFoundException {
        badgeDAO.update(badge);
    }

    @Override
    public void deleteBadge(Badge badge) throws GamificationDomainEntityNotFoundException {
        badgeDAO.delete(badge);
    }
    
    
}
