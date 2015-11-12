package ch.heigvd.amt.gamification.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

/**
 *
 * @author Parfait Noubissi
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

    // User must have valide password 
    @Column(nullable = false)
    private String password;

    @ManyToMany //
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


    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }


    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    public void setEmail(String email) {
        this.email = email;
    }

  
    public void setPassword(String password) {
        this.password = password;
    }

    
    public List<Role> getRoles() {
        return roles;
    }

  
    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public List<Application> getApps() {
        return apps;
    }
    
}
