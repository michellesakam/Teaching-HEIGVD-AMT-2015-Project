package ch.heigvd.amt.gamification.controllers;

import ch.heigvd.amt.gamification.model.entities.Account;
import ch.heigvd.amt.gamification.rest.dto.AccountDTO;
import ch.heigvd.amt.gamification.services.AccountsManagerLocal;
import ch.heigvd.amt.gamification.services.passwordvalidation.BadPasswordException;
import java.io.IOException;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.EJBException;

/**
 *
 * @author Raphaël Racine
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
        
        request.setAttribute("title", "Registration Page");
        request.getRequestDispatcher("/WEB-INF/pages/account_registration.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String email = req.getParameter("Email");
        String firstName = req.getParameter("First_name");
        String lastName = req.getParameter("Last_name");
        String password = req.getParameter("Password");
        String confirm = req.getParameter("Confirm");

        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setEmail(email);
        accountDTO.setFirstName(firstName);
        accountDTO.setLastName(lastName);
        accountDTO.setPassword(password);
        
        req.setAttribute("title", "Registration Page");

        if (password.equals(confirm)) {
            Account a = new Account();
            a.setEmail(email);
            a.setFirstName(firstName);
            a.setLastName(lastName);
            a.setPassword(password);

            try {
                accountsManager.createAccount(a);
            }
            catch(EJBException e) { // Exception si l'email existe déjà
                List<String> errors = new LinkedList<>();
                errors.add("Impossible to register an account, probably the email already exists !");
                req.setAttribute("errors", errors);
                req.setAttribute("accountDTO", accountDTO);
                req.getRequestDispatcher("/WEB-INF/pages/account_registration.jsp").forward(req, resp);
                return; // Arrêt du code pour éviter qu'il continue                
            } catch (BadPasswordException ex) {
                List<String> errors = new LinkedList<>();
                errors.add(ex.getMessage());
                req.setAttribute("errors", errors);
                req.setAttribute("accountDTO", accountDTO);
                req.getRequestDispatcher("/WEB-INF/pages/account_registration.jsp").forward(req, resp);
                return; // Arrêt du code pour éviter qu'il continue
            }
            
            req.getSession().setAttribute("principal", a);
            resp.sendRedirect(req.getContextPath() + "/pages/yourApps");

        } else {
            List<String> errors = new ArrayList<>();
            errors.add("The two passwords are not the same.");
            req.setAttribute("errors", errors); 
            req.setAttribute("accountDTO", accountDTO);
            req.getRequestDispatcher("/WEB-INF/pages/account_registration.jsp").forward(req, resp);
        }

    }

}
