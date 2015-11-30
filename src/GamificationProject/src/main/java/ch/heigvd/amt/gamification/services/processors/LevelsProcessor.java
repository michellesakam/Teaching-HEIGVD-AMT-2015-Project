package ch.heigvd.amt.gamification.services.processors;

import ch.heigvd.amt.gamification.dto.LevelDTO;
import ch.heigvd.amt.gamification.model.Application;
import ch.heigvd.amt.gamification.model.Level;
import ch.heigvd.amt.gamification.services.LevelsManagerLocal;
import ch.heigvd.amt.gamification.services.dao.GamificationDomainEntityNotFoundException;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Raphaël Racine
 */
@Stateless
public class LevelsProcessor extends GamificationDTOProcessor implements LevelsProcessorLocal {

    @EJB
    private LevelsManagerLocal levelsManager;

    @Override
    public void processPostLevel(LevelDTO levelDTO) {
        Application application = super.tryToRetrieveApplication(levelDTO.getApiKey());

        Level level = new Level();
        level.setName(levelDTO.getName());
        level.setMinimumPoints(levelDTO.getMinimumPoints());

        levelsManager.assignLevelToApplication(application, level);
    }

    @Override
    public void processPutLevel(Long levelID, LevelDTO levelDTO) {
        Application application = super.tryToRetrieveApplication(levelDTO.getApiKey());

        try {
            Level level = levelsManager.findById(levelID);

            if (level.getApplication() == application) {
                level.setName(levelDTO.getName());
                level.setMinimumPoints(levelDTO.getMinimumPoints());
            } else {
                throw new Error("This application doens't have level with specified levelID");
            }
        } catch (GamificationDomainEntityNotFoundException ex) {
            throw new NullPointerException("This level doesn't exists");
        }
    }

    @Override
    public void processDeleteLevel(Long levelID, String apiKey) {
        Application application = super.tryToRetrieveApplication(apiKey);

        try {
            Level level = levelsManager.findById(levelID);

            if (level.getApplication() == application) {
                levelsManager.deleteLevel(level);
            } else {
                throw new Error("This application doens't have level with specified levelID");
            }
        } catch (GamificationDomainEntityNotFoundException ex) {
            throw new NullPointerException("This level doesn't exists");
        }
    }

}
