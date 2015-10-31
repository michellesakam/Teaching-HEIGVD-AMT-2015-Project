package ch.heigvd.amt.gamification.controllers;

import ch.heigvd.amt.gamification.model.entities.Account;
import ch.heigvd.amt.gamification.model.entities.Application;
import ch.heigvd.amt.gamification.rest.dto.ApplicationDTO;
import ch.heigvd.amt.gamification.services.ApplicationsManagerLocal;
import ch.heigvd.amt.gamification.services.dao.GamificationDomainEntityNotFoundException;
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
public class ApplicationsServlet extends HttpServlet {

    @EJB
    private ApplicationsManagerLocal applicationsManager;

    private final String TITLE_EDIT_APPLICATION = "App details";
    private final String TITLE_ADD_APPLICATION = "Register New App";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        boolean edit = Boolean.parseBoolean(req.getParameter("edit"));
        String title;

        if (edit) { // If the URL is /application?edit=true

            title = TITLE_EDIT_APPLICATION;
            req.setAttribute("edit", true);

            try {
                long idApp = Long.parseLong(req.getParameter("idApplication"));

                Application application = applicationsManager.findById(idApp);
                req.setAttribute("nbEndUsers", applicationsManager.nbEndUsersOfApplication(application));
                req.setAttribute("application", application);

            } catch (GamificationDomainEntityNotFoundException ex) {

                List<String> errors = new LinkedList<>();
                errors.add(ex.getMessage());
                req.setAttribute("errors", errors);

            }

        } else { // If the URL is /application?edit=false
            title = TITLE_ADD_APPLICATION;
        }

        req.setAttribute("title", title);
        req.getRequestDispatcher("/WEB-INF/pages/application_registration.jsp").forward(req, resp);

    }

    private void createApplication(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("edit").equals("true")) {
            createApplication(req, resp);
        } else {
            editApplication(req, resp);
        }

        req.setAttribute("title", "Register New App");
        Account currentAccount = (Account) req.getSession().getAttribute("principal");

        String name = req.getParameter("Name");
        String description = req.getParameter("description");
        boolean isEnable = Boolean.parseBoolean(req.getParameter("isEnable"));

        ApplicationDTO applicationDTO = new ApplicationDTO();
        applicationDTO.setDescription(description);
        applicationDTO.setName(name);
        applicationDTO.setIsEnable(isEnable);

        Application application = new Application();
        application.setIsEnable(isEnable);
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

    private void editApplication(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        req.setAttribute("edit", true);
        req.setAttribute("title", "App details");

        String name = req.getParameter("Name");
        String description = req.getParameter("description");
        boolean isEnable = Boolean.parseBoolean(req.getParameter("isEnable"));
        long idApplication = Long.parseLong(req.getParameter("idApplication"));

        Application application = null;
        List<String> errors = new LinkedList<>();

        try {
            application = applicationsManager.findById(idApplication);
            application.setDescription(description);
            application.setIsEnable(isEnable);
            application.setName(name);
            applicationsManager.updateApplication(application);
            resp.sendRedirect(req.getContextPath() + "/pages/yourApps");
        } catch (EJBException e) {
            errors.add("Impossible to update an application, probably the name already exists !");
            req.setAttribute("application", application);
            req.setAttribute("errors", errors);
            req.setAttribute("nbEndUsers", applicationsManager.nbEndUsersOfApplication(application));
            req.getRequestDispatcher("/WEB-INF/pages/application_registration.jsp").forward(req, resp);
        } catch (GamificationDomainEntityNotFoundException ex) {
            errors.add("Application has not be founded, impossible to update !");
            req.setAttribute("errors", errors);
            resp.sendRedirect(req.getContextPath() + "/pages/yourApps");
        }
    }

}
