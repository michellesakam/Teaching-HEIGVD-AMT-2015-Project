package ch.heigvd.amt.gamification.controllers.ajax;

import ch.heigvd.amt.gamification.model.entities.Application;
import ch.heigvd.amt.gamification.services.ApplicationsManagerLocal;
import ch.heigvd.amt.gamification.services.dao.GamificationDomainEntityNotFoundException;
import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * This servlet is used to process AJAX requests about Applications
 *
 * @author Raphaël Racine
 */
public class AjaxApplicationsServlet extends HttpServlet {

    @EJB
    private ApplicationsManagerLocal applicationsManager;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        String action = req.getParameter("action");
        String idApplication = req.getParameter("idApplication");

        if (action != null && idApplication != null) {

            try {
                Application app = applicationsManager.findById(Long.parseLong(idApplication));

                switch (action) {
                    case "enableApplication":
                        applicationsManager.enableApplication(app);
                        break;
                    case "disableApplication":
                        applicationsManager.disableApplication(app);
                        break;
                }

            } catch (GamificationDomainEntityNotFoundException ex) {
                resp.setStatus(500);
            }
        }
    }

}
