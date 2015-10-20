package ch.heigvd.amt.gamification.model.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

/**
 *
 * @author Raphaël Racine
 */
@Entity

@NamedQueries({
    @NamedQuery(name = "Account.findByEmail", query = "SELECT a FROM Account a WHERE a.email = :email"),
    @NamedQuery(name = "Account.findAll", query = "SELECT a FROM Account a"),
    @NamedQuery(name = "Account.numberOfAccounts", query = "SELECT COUNT(a) FROM Account a")
})

public class Account extends AbstractDomainModelEntity<Long> {

    public Account() {
    }

    private String firstName;
    private String lastName;

    @Column(nullable = false, unique = true)
    private String email;

    // l'utilisateur doit avoir une adresse email valide 
    @Column(nullable = false)
    private String password;

    @ManyToMany // relation plusieurs à plusieurs
    private List<Role> roles;

    @OneToMany(mappedBy = "acount")
    private List<Application> apps;
    
    public Account(String firstName, String lastName, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
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

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the roles
     */
    public List<Role> getRoles() {
        return roles;
    }

    /**
     * @param roles the roles to set
     */
    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    /**
     * @return the apps
     */
    public List<Application> getApps() {
        return apps;
    }
    
}
