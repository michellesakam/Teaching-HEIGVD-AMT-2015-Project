package ch.heigvd.amt.gamification.services.passwordvalidation;

/**
 * 
 * @author Raphaël Racine
 */
public class BadPasswordException extends Exception {
    
    private final String message;
    
    public BadPasswordException(String message) {
        this.message = message;
    }
    
    @Override
    public String getMessage() {
        return message;
    }

}
