package ch.heigvd.amt.gamification.services.processors;

import ch.heigvd.amt.gamification.dto.IGamificationDTO;
import javax.ejb.Local;

/**
 *
 * @author Raphaël Racine
 * @param <T>
 * @param <K>
 */
@Local
public interface IGamificationDTOProcessor<T extends IGamificationDTO, K> {    
    public void postDTO(String apiKey, T dto);
    public void putDTO(String apiKey, K id, T dto);
    public void deleteDTO(K id, String apiKey);    
}
