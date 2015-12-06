package ch.heigvd.amt.gamification.services.processors;

import ch.heigvd.amt.gamification.dto.BadgeDTO;
import ch.heigvd.amt.gamification.model.Application;
import ch.heigvd.amt.gamification.model.Badge;
import ch.heigvd.amt.gamification.services.BadgesManagerLocal;
import ch.heigvd.amt.gamification.services.dao.GamificationDomainEntityNotFoundException;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Raphaël Racine
 */
@Stateless
public class BadgesProcessor extends GamificationDTOProcessor<BadgeDTO, Long> implements BadgesProcessorLocal {

    @EJB
    private BadgesManagerLocal badgesManager;

    @Override
    public void postDTO(String apiKey, BadgeDTO dto) {
        Application application = super.tryToRetrieveApplication(apiKey);

        Badge badge = new Badge();
        badge.setName(dto.getName());
        badgesManager.assignBadgeToAnApplication(application, badge);
    }

    @Override
    public void putDTO(String apiKey, Long id, BadgeDTO dto) {
        Application application = super.tryToRetrieveApplication(apiKey);

        try {
            Badge badge = badgesManager.findById(id);
            if (badge.getApplication() == application) {
                badge.setName(dto.getName());
            } else {
                throw new Error("This application doens't have badge with specified badgeID");
            }

        } catch (GamificationDomainEntityNotFoundException ex) {
            throw new NullPointerException("This badge doesn't exists");
        }
    }

    @Override
    public void deleteDTO(Long id, String apiKey) {
        Application application = super.tryToRetrieveApplication(apiKey);

        try {
            Badge badge = badgesManager.findById(id);
            if (badge.getApplication() == application) {
                badgesManager.deleteBadge(badge);
            } else {
                throw new Error("This application doens't have badge with specified badgeID");
            }

        } catch (GamificationDomainEntityNotFoundException ex) {
            throw new NullPointerException("This badge doesn't exists");
        }
    }

}
