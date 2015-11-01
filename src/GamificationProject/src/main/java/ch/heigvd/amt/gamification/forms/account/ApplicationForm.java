package ch.heigvd.amt.gamification.forms.account;

import javax.servlet.ServletRequest;

/**
 * Cette classe représente le formulaire de création ou de modification
 * d'une application
 * 
 * @author Raphaël Racine
 */
public class ApplicationForm {
    private final String name;
    private final String description;
    private final boolean isEnable;
    
    public ApplicationForm(ServletRequest request) {
        this.name = request.getParameter("Name");
        this.description = request.getParameter("description");
        this.isEnable = Boolean.parseBoolean(request.getParameter("isEnable"));
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public boolean getIsEnable() {
        return isEnable;
    }
    
    
}
