package ch.heigvd.amt.gamification.services.processors;

import ch.heigvd.amt.gamification.dto.GamificationDTO;
import javax.ejb.Local;

/**
 *
 * @author Raphaël Racine
 * @param <T>
 * @param <K>
 */
@Local
public interface IGamificationDTOProcessor<T extends GamificationDTO, K> {    
    public void postDTO(T dto);
    public void putDTO(K id, T dto);
    public void deleteDTO(K id, String apiKey);    
}
