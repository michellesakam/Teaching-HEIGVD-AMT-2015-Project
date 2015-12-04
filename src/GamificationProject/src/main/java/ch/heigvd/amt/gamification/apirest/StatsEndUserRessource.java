package ch.heigvd.amt.gamification.apirest;

import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 *
 * @author Raphaël Racine
 */
@Stateless
@Path("statsEndUser")
public class StatsEndUserRessource {

    @GET
    @Produces("application/json")
    @Path("/widgetBadges/{endUserNumber}")
    public void getEndUserBadgesStats(@HeaderParam("Authorization") String apiKey,
            @PathParam(value = "endUserNumber") String endUserNumber) {
        // TODO        
    }

    @GET
    @Produces("application/json")
    @Path("/widgetPoints/{endUserNumber}")
    public void getEndUserPointsStats(@HeaderParam("Authorization") String apiKey,
            @PathParam(value = "endUserNumber") String endUserNumber) {
        // TODO        
    }

    @GET
    @Produces("application/json")
    @Path("/widgetLevels/{endUserNumber}")
    public void getEndUserLevelsStats(@HeaderParam("Authorization") String apiKey,
            @PathParam(value = "endUserNumber") String endUserNumber) {
        // TODO        
    }

    @GET
    @Produces("application/json")
    @Path("/badges/{endUserNumber}")
    public void getEndUserBadgesNb(@HeaderParam("Authorization") String apiKey,
            @PathParam(value = "endUserNumber") String endUserNumber) {
        // TODO    
        
    }
    @GET
    @Produces("application/json")
    @Path("/badges/{endUserNumber}")
    public void getEndUserPointsNb(@HeaderParam("Authorization") String apiKey,
            @PathParam(value = "endUserNumber") String endUserNumber) {
        // TODO    
        
    }
}
