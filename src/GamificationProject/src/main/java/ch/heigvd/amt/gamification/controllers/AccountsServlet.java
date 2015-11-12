package ch.heigvd.amt.gamification.controllers;

import ch.heigvd.amt.gamification.forms.account.AccountForm;
import ch.heigvd.amt.gamification.forms.account.NotSamePasswordException;
import ch.heigvd.amt.gamification.services.dao.GamificationDomainEntityNotFoundException;
import ch.heigvd.amt.gamification.model.Account;
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

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        boolean edit = Boolean.parseBoolean(request.getParameter("edit"));
        String title = edit ? TITLE_EDIT_ACCOUNT : TITLE_ADD_ACCOUNT;

        if (edit) {
            request.setAttribute("accountForm", request.getSession().getAttribute("principal"));
            request.setAttribute("edit", true);
        }

        request.setAttribute("title", title);
        request.getRequestDispatcher("/WEB-INF/pages/account_registration.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        if (request.getParameter("edit").equals("true")) { // If we have the URL /account?edit=true
            editAccount(request, response);
        } else { // If we have the URL /account?edit=false
            createAccount(request, response);
        }

    }

    private void editAccount(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setAttribute("edit", true);
        request.setAttribute("title", TITLE_EDIT_ACCOUNT);

        AccountForm form = null;

        try {
            form = new AccountForm(request);
            form.checkEntry();

            Account currentAccount = (Account) request.getSession().getAttribute("principal");
            currentAccount.setFirstName(form.getFirstName());
            currentAccount.setLastName(form.getLastName());
            currentAccount.setPassword(form.getPassword());

            accountsManager.updateAccount(currentAccount);

            response.sendRedirect(request.getContextPath() + "/pages/yourApps");

        } catch (GamificationDomainEntityNotFoundException | BadPasswordException | NotSamePasswordException e) {
            List<String> errors = new ArrayList<>();
            errors.add(e.getMessage());
            request.setAttribute("accountForm", form);
            request.setAttribute("errors", errors);
            request.getRequestDispatcher("/WEB-INF/pages/account_registration.jsp").forward(request, response);
        }
    }

    private void createAccount(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setAttribute("title", TITLE_ADD_ACCOUNT);

        AccountForm form = null;
        List<String> errors = new LinkedList<>();

        try {
            form = new AccountForm(request);
            form.checkEntry();

            Account a = new Account();
            a.setEmail(form.getEmail());
            a.setFirstName(form.getFirstName());
            a.setLastName(form.getLastName());
            a.setPassword(form.getPassword());

            accountsManager.createAccount(a);

            request.getSession().setAttribute("principal", a);
            response.sendRedirect(request.getContextPath() + "/pages/yourApps");

        } catch (NotSamePasswordException 
                | BadPasswordException
                | EJBException ex) {
            
            if(ex instanceof EJBException)
                errors.add(ex.getMessage());
            else
                errors.add("Impossible to register an account, probably the email already exists !");
            
            request.setAttribute("errors", errors);
            request.setAttribute("accountForm", form);
            request.getRequestDispatcher("/WEB-INF/pages/account_registration.jsp").forward(request, response);
        }

    }

}
