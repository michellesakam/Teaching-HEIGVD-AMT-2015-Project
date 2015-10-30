package ch.heigvd.amt.gamification.services;

/**
 *
 * @author Raphaël Racine
 */
public class BadPasswordException extends Exception {

    @Override
    public String getMessage() {
        return "The password need to have a length minimum 8 characters";
    }

    public static void checkPasswordPolitic(String password) throws BadPasswordException {
        // The password need to have 8 characters minimum
        if(password.length() < 8)
            throw new BadPasswordException();
    }

}
