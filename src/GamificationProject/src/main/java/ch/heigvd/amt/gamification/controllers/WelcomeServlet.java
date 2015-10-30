package ch.heigvd.amt.gamification.controllers;

import ch.heigvd.amt.gamification.services.AccountsManagerLocal;
import ch.heigvd.amt.gamification.services.ApplicationsManagerLocal;
import ch.heigvd.amt.gamification.services.EndUsersManagerLocal;
import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Samira Kouchali
 *         Edited by Raphaël Racine
 */
public class WelcomeServlet extends HttpServlet {
    
    @EJB
    private AccountsManagerLocal accountsManager;
    
    @EJB
    private ApplicationsManagerLocal applicationsManager;
    
    @EJB
    private EndUsersManagerLocal endUsersManager;
    
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {       
        
        final int nbLastDayEndUsers = 30;
        
        request.setAttribute("title", "Login Page");
        request.setAttribute("nbAccounts", accountsManager.numbersOfAccount());
        request.setAttribute("nbApplications", applicationsManager.numberOfApplicationsManaged());
        request.setAttribute("nbEndUser", endUsersManager.numberOfEndUsersCreatedDuringLastNbDays(nbLastDayEndUsers));
        request.setAttribute("nbLastDays", nbLastDayEndUsers);
        
        request.getRequestDispatcher("/WEB-INF/pages/welcome.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
    
    

}
