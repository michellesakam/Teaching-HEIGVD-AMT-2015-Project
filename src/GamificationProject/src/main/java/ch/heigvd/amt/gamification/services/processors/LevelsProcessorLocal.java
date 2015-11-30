package ch.heigvd.amt.gamification.services.processors;

import ch.heigvd.amt.gamification.dto.LevelDTO;
import javax.ejb.Local;

/**
 *
 * @author Raphaël Racine
 */
@Local
public interface LevelsProcessorLocal extends IGamificationDTOProcessor<LevelDTO, Long> {
}
