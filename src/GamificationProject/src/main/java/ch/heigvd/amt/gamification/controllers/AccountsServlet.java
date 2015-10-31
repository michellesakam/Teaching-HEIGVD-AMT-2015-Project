package ch.heigvd.amt.gamification.controllers;

import ch.heigvd.amt.gamification.services.dao.GamificationDomainEntityNotFoundException;
import ch.heigvd.amt.gamification.model.entities.Account;
import ch.heigvd.amt.gamification.rest.dto.AccountDTO;
import ch.heigvd.amt.gamification.services.AccountsManagerLocal;
import ch.heigvd.amt.gamification.services.passwordvalidation.BadPasswordException;
import java.io.IOException;
import java.util.ArrayList;
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
 *
 */
public class AccountsServlet extends HttpServlet {

    @EJB
    private AccountsManagerLocal accountsManager;
    
    private final String TITLE_ADD_ACCOUNT = "Registration Page";
    private final String TITLE_EDIT_ACCOUNT = "Edit your account details";

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

        boolean edit = Boolean.parseBoolean(request.getParameter("edit"));

        if (edit) {
            request.setAttribute("edit", true);
            request.setAttribute("title", TITLE_EDIT_ACCOUNT);
        } else {
            request.setAttribute("title", TITLE_ADD_ACCOUNT);
        }
        
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

        if(request.getParameter("edit").equals("true")) {
            doPut(request, response);
            return;
        }
        
        String email = request.getParameter("Email");
        String firstName = request.getParameter("First_name");
        String lastName = request.getParameter("Last_name");
        String password = request.getParameter("Password");
        String confirm = request.getParameter("Confirm");

        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setEmail(email);
        accountDTO.setFirstName(firstName);
        accountDTO.setLastName(lastName);
        accountDTO.setPassword(password);

        request.setAttribute("title", TITLE_ADD_ACCOUNT);

        if (password.equals(confirm)) {
            Account a = new Account();
            a.setEmail(email);
            a.setFirstName(firstName);
            a.setLastName(lastName);
            a.setPassword(password);

            try {
                accountsManager.createAccount(a);
            } catch (EJBException e) { // Exception si l'email existe déjà
                List<String> errors = new LinkedList<>();
                errors.add("Impossible to register an account, probably the email already exists !");
                request.setAttribute("errors", errors);
                request.setAttribute("accountDTO", accountDTO);
                request.getRequestDispatcher("/WEB-INF/pages/account_registration.jsp").forward(request, response);
                return; // Arrêt du code pour éviter qu'il continue                
            } catch (BadPasswordException ex) {
                List<String> errors = new LinkedList<>();
                errors.add(ex.getMessage());
                request.setAttribute("errors", errors);
                request.setAttribute("accountDTO", accountDTO);
                request.getRequestDispatcher("/WEB-INF/pages/account_registration.jsp").forward(request, response);
                return; // Arrêt du code pour éviter qu'il continue
            }

            request.getSession().setAttribute("principal", a);
            response.sendRedirect(request.getContextPath() + "/pages/yourApps");

        } else {
            List<String> errors = new ArrayList<>();
            errors.add("The two passwords are not the same.");
            request.setAttribute("errors", errors);
            request.setAttribute("accountDTO", accountDTO);
            request.getRequestDispatcher("/WEB-INF/pages/account_registration.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
