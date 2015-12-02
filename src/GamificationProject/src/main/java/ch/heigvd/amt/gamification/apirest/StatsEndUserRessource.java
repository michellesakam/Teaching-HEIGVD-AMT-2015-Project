/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.amt.gamification.apirest;


import ch.heigvd.amt.gamification.dao.EndUserDAOLocal;
import ch.heigvd.amt.gamification.dto.LevelDTO;
import ch.heigvd.amt.gamification.dto.StatsEndUserDTO;
import ch.heigvd.amt.gamification.services.ApplicationsManagerLocal;
import ch.heigvd.amt.gamification.services.EndUsersManagerLocal;
import ch.heigvd.amt.gamification.services.LevelsManagerLocal;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;

/**
 *
 * @author Raphaël Racine
 */
@Stateless
@Path("statsEndUser")
public class StatsEndUserRessource {
    
    @EJB
    private ApplicationsManagerLocal applicationsManager;
    
    @EJB
    private EndUsersManagerLocal endUserManager;
    
    @POST
    @Consumes("application/json")
    public void postEndUserStats(StatsEndUserDTO statsEndUserDTO) {
        
    }
    
    @PUT
    @Consumes("application/json")
    public void putEndUserStats(StatsEndUserDTO statsEndUserDTO) {
        // :TODO
    }
    
    @DELETE
    @Consumes("application/json")
    public void deleteEndUserStats(StatsEndUserDTO statsEndUserDTO) {
        // :TODO
    }
    
}
