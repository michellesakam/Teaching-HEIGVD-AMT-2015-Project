/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.amt.gamification.controllers;

import ch.heigvd.amt.gamification.model.entities.Account;
import ch.heigvd.amt.gamification.model.entities.Application;
import ch.heigvd.amt.gamification.rest.dto.ApplicationDTO;
import ch.heigvd.amt.gamification.services.ApplicationsManagerLocal;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Raphaël Racine
 */
public class ApplicationRegistrationServlet extends HttpServlet {

    @EJB
    private ApplicationsManagerLocal applicationsManager;

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

        request.setAttribute("title", "Register New App");
        request.getRequestDispatcher("/WEB-INF/pages/application_registration.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        req.setAttribute("title", "Register New App");
        Account currentAccount = (Account) req.getSession().getAttribute("principal");

        String name = req.getParameter("Name");
        String description = req.getParameter("description");
        
        ApplicationDTO applicationDTO = new ApplicationDTO();
        applicationDTO.setDescription(description);
        applicationDTO.setName(name);

        Application application = new Application();
        application.setIsEnable(true);
        application.setName(name);
        application.setDescription(description);

        try {
            applicationsManager.assignApplicationToAccount(application, currentAccount);
        } catch (EJBException e) {
            List<String> errors = new LinkedList<>();
            errors.add("Impossible to register an application, probably the name already exists !");
            req.setAttribute("errors", errors);
            req.setAttribute("applicationDTO", applicationDTO);
            req.getRequestDispatcher("/WEB-INF/pages/application_registration.jsp").forward(req, resp);
            return; // Arrêt du code pour éviter qu'il continue
        }
        
        resp.sendRedirect(req.getContextPath() + "/pages/yourApps");
    }

}
