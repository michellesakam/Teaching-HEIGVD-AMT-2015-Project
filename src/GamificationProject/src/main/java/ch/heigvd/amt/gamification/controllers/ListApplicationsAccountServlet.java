package ch.heigvd.amt.gamification.controllers;

import ch.heigvd.amt.gamification.model.Account;
import ch.heigvd.amt.gamification.model.Application;
import ch.heigvd.amt.gamification.services.ApplicationsManagerLocal;
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
    
    private final String TITLE = "Your Apps";
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {       
        
        request.setAttribute("title", TITLE);
        
        Account currentAccount = (Account) request.getSession().getAttribute("principal");
        
        List<Application> applicationsOfCurrentAccount 
                = applicationsManager.applicationsOfAnAccountWithEndUsersNumber(currentAccount);
        
        request.setAttribute("applications", applicationsOfCurrentAccount);        
        request.getRequestDispatcher("/WEB-INF/pages/applications_of_an_account.jsp").forward(request, response);
    }   

}
