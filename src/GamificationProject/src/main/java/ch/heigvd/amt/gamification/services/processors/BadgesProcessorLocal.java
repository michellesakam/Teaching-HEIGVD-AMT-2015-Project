package ch.heigvd.amt.gamification.services.processors;

import ch.heigvd.amt.gamification.dto.BadgeDTO;
import javax.ejb.Local;

/**
 *
 * @author Raphaël Racine
 */
@Local
public interface BadgesProcessorLocal {
    public void processPostBadge(BadgeDTO badgeDTO);
    public void processPutBadge(Long badgeID, BadgeDTO badgeDTO);
    public void processDeleteBadge(Long badgeID, String apiKey);
}
