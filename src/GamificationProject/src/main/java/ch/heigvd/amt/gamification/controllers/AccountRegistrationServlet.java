/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.amt.gamification.controllers;

import ch.heigvd.amt.gamification.model.Account;
import java.io.IOException;
import javax.servlet.ServletException;
;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ch.heigvd.amt.gamification.services.AccountsManagerLocal;
import static com.sun.corba.se.spi.presentation.rmi.StubAdapter.request;
import javax.ejb.EJB;

/**
 *
 * @author Samira Kouchali
 */


public class AccountRegistrationServlet extends HttpServlet {

    @EJB
    private AccountsManagerLocal accountsManager;

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

        request.getRequestDispatcher("/WEB-INF/pages/account_registration.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String email = req.getParameter("Email");
        String firstName = req.getParameter("First_name");
        String lastName = req.getParameter("Last_name");
        String password = req.getParameter("Password");
        String confirm = req.getParameter("Confirm");

        if (confirm != password) {
            System.out.println("Les mots de passe ne sont pas identiques");
        }

        Account a = new Account(firstName, lastName, email, password);
        boolean accountAlreadyExists = accountsManager.accountExists(a);
        
        if (accountAlreadyExists) {
            System.out.println("Ce Compte dejà utilisé");
        } else {
            accountsManager.createAccount(a);
            req.getSession().setAttribute("principal", a);
            resp.sendRedirect(req.getContextPath() + "/pages/yourApps");
        }

    }

}
