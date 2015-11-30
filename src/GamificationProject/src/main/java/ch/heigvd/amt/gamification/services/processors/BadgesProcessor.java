package ch.heigvd.amt.gamification.services.processors;

import ch.heigvd.amt.gamification.dto.BadgeDTO;
import ch.heigvd.amt.gamification.model.Application;
import ch.heigvd.amt.gamification.model.Badge;
import ch.heigvd.amt.gamification.services.ApplicationsManagerLocal;
import ch.heigvd.amt.gamification.services.BadgesManagerLocal;
import ch.heigvd.amt.gamification.services.dao.GamificationDomainEntityNotFoundException;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Raphaël Racine
 */
@Stateless
public class BadgesProcessor extends GamificationDTOProcessor implements BadgesProcessorLocal {

    @EJB
    private ApplicationsManagerLocal applicationsManager;

    @EJB
    private BadgesManagerLocal badgesManager;

    @Override
    public void processPostBadge(BadgeDTO badgeDTO) {

        Application application = super.tryToRetrieveApplication(badgeDTO.getApiKey());
        
        Badge badge = new Badge();
        badge.setName(badgeDTO.getName());
        applicationsManager.assignBadgeToAnApplication(application, badge);

    }

    @Override
    public void processPutBadge(Long badgeID, BadgeDTO badgeDTO) {

        Application application = super.tryToRetrieveApplication(badgeDTO.getApiKey());

        try {
            Badge badge = badgesManager.findById(badgeID);
            if (badge.getApplication() == application) {
                badge.setName(badgeDTO.getName());
            } else {
                throw new Error("This application doens't have badge with specified badgeID");
            }

        } catch (GamificationDomainEntityNotFoundException ex) {
            throw new NullPointerException("This badge doesn't exists");
        }

    }

    @Override
    public void processDeleteBadge(Long badgeID, String apiKey) {

        Application application = super.tryToRetrieveApplication(apiKey);

        try {
            Badge badge = badgesManager.findById(badgeID);
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
