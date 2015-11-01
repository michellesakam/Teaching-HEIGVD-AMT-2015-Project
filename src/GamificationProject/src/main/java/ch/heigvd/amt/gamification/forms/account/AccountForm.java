package ch.heigvd.amt.gamification.forms.account;

import javax.servlet.ServletRequest;

/**
 * Cette classe représente le formulaire permettant de modifier ou d'éditer un
 * compte
 *
 * @author Raphaël Racine
 */
public class AccountForm {

    private final ServletRequest request;

    private final String firstName;
    private final String lastName;
    private final String email;
    private final String password;
    private final String confirmPassword;

    public AccountForm(ServletRequest request) {
        this.request = request;
        this.firstName = request.getParameter("First_name");
        this.lastName = request.getParameter("Last_name");
        this.password = request.getParameter("Password");
        this.confirmPassword = request.getParameter("Confirm");
        this.email = request.getParameter("Email");
    }
    
    public void checkEntry() throws NotSamePasswordException {
        if(!password.equals(confirmPassword))
            throw new NotSamePasswordException();
    }

    public ServletRequest getRequest() {
        return request;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }
}
