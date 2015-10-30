package ch.heigvd.amt.gamification.services.passwordvalidation;

public abstract class PasswordPoliticValidator {
    
    public static void checkPassword(String password) throws BadPasswordException {
        if(password.length() < 8)
            throw new BadPasswordException("The password need to have minimum 8 characters of length");
    }
    
}
