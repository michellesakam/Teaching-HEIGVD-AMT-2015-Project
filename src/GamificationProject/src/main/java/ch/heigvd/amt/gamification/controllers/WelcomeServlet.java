/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.amt.gamification.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ch.heigvd.amt.gamification.services.AccountsManagerLocal;
import javax.ejb.EJB;

/**
 *
 * @author Samira Kouchali
 */
public class WelcomeServlet extends HttpServlet {

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

        
        
        request.getRequestDispatcher("/WEB-INF/pages/welcome.jsp").forward(request, response);
    }

}
