
package ch.heigvd.amt.gamification.services.processors;

import ch.heigvd.amt.gamification.dto.EventDTO;
import javax.ejb.Local;

/**
 *
 * @author michelle meguep
 */
@Local
public interface EventsProcessorLocal extends IGamificationDTOProcessor<EventDTO, Long> {
}
