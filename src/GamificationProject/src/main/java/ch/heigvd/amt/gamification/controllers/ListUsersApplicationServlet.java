package ch.heigvd.amt.gamification.controllers;

import ch.heigvd.amt.gamification.model.entities.Application;
import ch.heigvd.amt.gamification.model.entities.EndUser;
import ch.heigvd.amt.gamification.services.ApplicationsManagerLocal;
import ch.heigvd.amt.gamification.services.dao.GamificationDomainEntityNotFoundException;
import ch.heigvd.amt.gamification.util.Pagination;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Raphaël Racine
 */
public class ListUsersApplicationServlet extends HttpServlet {

    @EJB
    private ApplicationsManagerLocal applicationsManager;
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        // We need to get parameter for pagination
        int currentNumPage = 1; // Default value
        int nbEndUSersPerPage = 10; // Default value
        
        String parameterCurrentNumPage = req.getParameter("currentNumPage");
        String parameterNbEndUsersPerPage = req.getParameter("nbEndUsersPerPage");
        
        if(parameterCurrentNumPage != null && parameterNbEndUsersPerPage != null) {
            currentNumPage = Integer.parseInt(parameterCurrentNumPage);
            nbEndUSersPerPage = Integer.parseInt(parameterNbEndUsersPerPage);
        }
        
        // Weed need to get the application with id
        long idApplication = Long.parseLong(req.getParameter("idApplication"));
        
        try {
            
            Application app = applicationsManager.findById(idApplication);
            long nbEndUsers = applicationsManager.nbEndUsersOfApplication(app);            
            
            nbEndUSersPerPage = nbEndUSersPerPage < 1 ? 1 : nbEndUSersPerPage;
            long nbPages = Pagination.computeTotalNbPages(nbEndUsers, nbEndUSersPerPage);
            
            currentNumPage = currentNumPage < 1 ? 1 : (currentNumPage > (int) nbPages ? (int) nbPages : currentNumPage);            
            
            // We need to get EndUsers of this application (with pagination request)
            List<EndUser> endUsers = applicationsManager.findEndUsersAndPaginate(app, currentNumPage - 1, nbEndUSersPerPage);            
            req.setAttribute("application", app);
            req.setAttribute("endUsersPaginated", endUsers);
            req.setAttribute("numPage", currentNumPage);
            req.setAttribute("nbPages", nbPages);
            req.setAttribute("nbEndUsersPerPage", nbEndUSersPerPage);
            
        } catch (GamificationDomainEntityNotFoundException ex) {            
            List<String> errors = new LinkedList<>();
            errors.add("Application has not be found");
            req.setAttribute("errors", errors);
        }
        
        req.getRequestDispatcher("/WEB-INF/pages/list_user_of_application.jsp").forward(req, resp);
    }
        
}
