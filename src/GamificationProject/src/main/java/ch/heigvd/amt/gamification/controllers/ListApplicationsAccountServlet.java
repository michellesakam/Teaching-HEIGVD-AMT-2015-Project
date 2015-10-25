package ch.heigvd.amt.gamification.controllers;

import ch.heigvd.amt.gamification.model.entities.Account;
import ch.heigvd.amt.gamification.model.entities.Application;
import ch.heigvd.amt.gamification.services.ApplicationsManagerLocal;
import ch.heigvd.amt.gamification.services.dao.GamificationDomainEntityNotFoundException;
import java.io.IOException;
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
public class ListApplicationsAccountServlet extends HttpServlet {

    @EJB
    private ApplicationsManagerLocal applicationsManager;
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {       
        
        request.setAttribute("title", "Your Apps");
        
        Account currentAccount = (Account) request.getSession().getAttribute("principal");
        
        List<Application> applicationsOfCurrentAccount 
                = applicationsManager.applicationsOfAnAccountWithEndUsersNumber(currentAccount);
        
        request.setAttribute("applications", applicationsOfCurrentAccount);        
        request.getRequestDispatcher("/WEB-INF/pages/applications_of_an_account.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        req.setAttribute("title", "Your Apps");
        
        // Disable or Enable application
        String action = req.getParameter("action");
        String idApplication = req.getParameter("idApplication");
        
        if(action != null && idApplication != null) {
            
            try {
                Application app = applicationsManager.findById(Long.parseLong(idApplication));
                        
                        switch(action) {
                            case "enableApplication":
                                applicationsManager.enableApplication(app);
                                break;
                            case "disableApplication":
                                applicationsManager.disableApplication(app);
                                break;
                        }
                        
            } catch (GamificationDomainEntityNotFoundException ex) {
                resp.setStatus(500);
            }
        }
        
    }    
    

}
