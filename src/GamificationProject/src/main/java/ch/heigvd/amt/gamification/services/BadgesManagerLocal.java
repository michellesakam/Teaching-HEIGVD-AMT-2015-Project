/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.amt.gamification.services;

import ch.heigvd.amt.gamification.model.Application;
import ch.heigvd.amt.gamification.model.Badge;
import ch.heigvd.amt.gamification.model.EndUser;
import ch.heigvd.amt.gamification.services.dao.GamificationDomainEntityNotFoundException;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Samira
 */
@Local
public interface BadgesManagerLocal {

    /**
     * Allow to edit a badge
     * @param badge The badge to edit
     * @throws GamificationDomainEntityNotFoundException 
     */
    public void editBadge(Badge badge) throws GamificationDomainEntityNotFoundException;

    /**
     * Allow to delete a badge
     * @param badge The badge to delete
     * @throws GamificationDomainEntityNotFoundException 
     */
    public void deleteBadge(Badge badge) throws GamificationDomainEntityNotFoundException;

    /**
     * Find all the badges of an application
     * @param application The concerned application (has to be managed)
     * @return All the badges of the application
     */
    public List<Badge> findByApplication(Application application);

    /**
     * Find a badge by his id
     * @param id The id of the badge
     * @return The badge which have this id
     * @throws GamificationDomainEntityNotFoundException 
     */
    public Badge findById(Long id) throws GamificationDomainEntityNotFoundException;

    /**
     * Find all the badges of an endUser in an application
     * @param endUser The concerned endUser (has to be managed)
     * @param application The application (has to be managed)
     * @return All the badges of the endUser in this application
     */
    public List<Badge> findByEndUser(EndUser endUser, Application application);

    /**
     * Assign a badge to an application
     *
     * @param application The concerned application (has to be managed)
     * @param badge The badge to assign
     */
    public void assignBadgeToAnApplication(Application application, Badge badge);
}
