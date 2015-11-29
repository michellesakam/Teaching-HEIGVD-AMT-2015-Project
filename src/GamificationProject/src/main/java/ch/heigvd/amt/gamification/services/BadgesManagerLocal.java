/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.amt.gamification.services;

import ch.heigvd.amt.gamification.model.Badge;
import ch.heigvd.amt.gamification.services.dao.GamificationDomainEntityNotFoundException;
import javax.ejb.Local;

/**
 *
 * @author Samira
 */
@Local
public interface BadgesManagerLocal {
    public void editBadge(Badge badge) throws GamificationDomainEntityNotFoundException;
    public void deleteBadge(Badge badge) throws GamificationDomainEntityNotFoundException;
}
