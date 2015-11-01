package ch.heigvd.amt.gamification.forms.account;

/**
 * Cette classe représente une exception qui peut être utilisée si un mot de
 * passe saisi lors de l'édition ou de la création d'un compte n'est pas
 * identique au mot de passe qui permet de confirmer.
 *
 * @author Raphaël Racine
 */
public class NotSamePasswordException extends Exception {

    @Override
    public String getMessage() {
        return "The two password are not the same !";
    }
    
}
