package ch.heigvd.amt.gamification.services;

import ch.heigvd.amt.gamification.dto.LevelDTO;
import javax.ejb.Local;

/**
 *
 * @author Raphaël Racine
 */
@Local
public interface LevelsProcessorLocal {

    public void processPostLevel(LevelDTO levelDTO);

    public void processPutLevel(Long levelID, LevelDTO levelDTO);

    public void processDeleteLevel(Long levelID, String apiKey);
}
