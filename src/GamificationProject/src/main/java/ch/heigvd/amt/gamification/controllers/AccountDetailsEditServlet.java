package ch.heigvd.amt.gamification.controllers;

import ch.heigvd.amt.gamification.services.dao.GamificationDomainEntityNotFoundException;
import ch.heigvd.amt.gamification.model.entities.Account;
import ch.heigvd.amt.gamification.services.AccountsManagerLocal;
import ch.heigvd.amt.gamification.services.passwordvalidation.BadPasswordException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Raphaël Racine
 *
 */
public class AccountDetailsEditServlet extends HttpServlet {

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
        request.setAttribute("edit", true);
        request.setAttribute("title", "Edit your account details");
        request.getRequestDispatcher("/WEB-INF/pages/account_registration.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setAttribute("edit", true);
        String firstName = request.getParameter("First_name");
        String lastName = request.getParameter("Last_name");
        String password = request.getParameter("Password");
        String confirm = request.getParameter("Confirm");

        if (password.equals(confirm)) {

            /* The account has to be modified is the account which is in
             *  session variable called principal (which have an id in database)
             */
            Account currentAccount = (Account) request.getSession().getAttribute("principal");
            currentAccount.setFirstName(firstName);
            currentAccount.setLastName(lastName);
            currentAccount.setPassword(password);

            try {
                accountsManager.updateAccount(currentAccount);
                response.sendRedirect(request.getContextPath() + "/pages/yourApps");
            } catch (GamificationDomainEntityNotFoundException e) {
                List<String> errors = new ArrayList<>();
                errors.add(e.getMessage());
                request.setAttribute("errors", errors);
                request.getRequestDispatcher("/WEB-INF/pages/account_registration.jsp").forward(request, response);
            } catch (BadPasswordException ex) {
                List<String> errors = new ArrayList<>();
                errors.add(ex.getMessage());
                request.setAttribute("errors", errors);
                request.getRequestDispatcher("/WEB-INF/pages/account_registration.jsp").forward(request, response);
            }

        } else {
            List<String> errors = new ArrayList<>();
            errors.add("The two passwords are not the same.");
            request.setAttribute("errors", errors);
            request.getRequestDispatcher("/WEB-INF/pages/account_registration.jsp").forward(request, response);
        }
    }

}
