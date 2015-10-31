package ch.heigvd.amt.gamification.services.passwordvalidation;

/**
 * 
 * This abstract class is used to check a politic on a password
 * 
 * @author Raphaël Racine
 */
public class PasswordPoliticValidator {
    
    /**
     * Check the password politic on the password in parameter
     * @param password
     * @throws BadPasswordException if the password doesnt respect politic
     */
    public static void checkPassword(String password) throws BadPasswordException {
        if(password.length() < 8)
            throw new BadPasswordException("The password need to have minimum 8 characters of length");
    }
    
}
