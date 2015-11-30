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
public class LevelsProcessor extends GamificationDTOProcessor<LevelDTO, Long> implements LevelsProcessorLocal {

    @EJB
    private LevelsManagerLocal levelsManager;

    @Override
    public void postDTO(String apiKey, LevelDTO dto) {
        Application application = super.tryToRetrieveApplication(apiKey);

        Level level = new Level();
        level.setName(dto.getName());
        level.setMinimumPoints(dto.getMinimumPoints());

        levelsManager.assignLevelToApplication(application, level);
    }

    @Override
    public void putDTO(String apiKey, Long id, LevelDTO dto) {
        Application application = super.tryToRetrieveApplication(apiKey);

        try {
            Level level = levelsManager.findById(id);

            if (level.getApplication() == application) {
                level.setName(dto.getName());
                level.setMinimumPoints(dto.getMinimumPoints());
            } else {
                throw new Error("This application doens't have level with specified levelID");
            }
        } catch (GamificationDomainEntityNotFoundException ex) {
            throw new NullPointerException("This level doesn't exists");
        }
    }

    @Override
    public void deleteDTO(Long id, String apiKey) {
        
        Application application = super.tryToRetrieveApplication(apiKey);

        try {
            Level level = levelsManager.findById(id);

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
