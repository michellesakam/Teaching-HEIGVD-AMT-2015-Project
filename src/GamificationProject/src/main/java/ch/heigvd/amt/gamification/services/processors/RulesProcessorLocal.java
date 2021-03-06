package ch.heigvd.amt.gamification.services.processors;

import ch.heigvd.amt.gamification.dto.RuleDTO;
import javax.ejb.Local;

/**
 *
 * @author Raphaël Racine
 */
@Local
public interface RulesProcessorLocal extends IGamificationDTOProcessor<RuleDTO, Long> {
}
