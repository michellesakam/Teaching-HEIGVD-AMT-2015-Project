package ch.heigvd.amt.gamification.services.processors;

import ch.heigvd.amt.gamification.dto.BadgeDTO;
import javax.ejb.Local;

/**
 *
 * @author Raphaël Racine
 */
@Local
public interface BadgesProcessorLocal extends IGamificationDTOProcessor<BadgeDTO, Long> {
}
