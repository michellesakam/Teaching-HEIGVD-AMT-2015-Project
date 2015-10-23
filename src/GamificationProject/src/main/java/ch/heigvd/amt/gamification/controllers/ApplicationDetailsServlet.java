/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.amt.gamification.controllers;

import ch.heigvd.amt.gamification.model.entities.Application;
import ch.heigvd.amt.gamification.services.ApplicationsManagerLocal;
import ch.heigvd.amt.gamification.services.dao.GamificationDomainEntityNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Raphaël Racine
 */
public class ApplicationDetailsServlet extends HttpServlet {

    @EJB
    private ApplicationsManagerLocal applicationsManager;
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        try {
            long idApp = Long.parseLong(req.getParameter("idApplication"));
            
            Application application = applicationsManager.findById(idApp);
            
            req.setAttribute("nbEndUsers", applicationsManager.nbEndUsersOfApplication(application));
            req.setAttribute("application", application);
            req.getRequestDispatcher("/WEB-INF/pages/application_details.jsp").forward(req, resp);
        } catch (GamificationDomainEntityNotFoundException ex) {
            Logger.getLogger(ApplicationDetailsServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
