package ch.heigvd.amt.gamification.model.entities;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author Raphaël Racine
 */
@Entity

@NamedQueries({
    @NamedQuery(name = "Application.numberOfApplications", query = "SELECT COUNT(a) FROM Application a"),
    @NamedQuery(name = "Application.findAll", query = "SELECT a FROM Application a")
})

public class Application extends AbstractDomainModelEntity<Long> {

    public Application() {
    }
    /**
     * le nom de l'application ne doit pas être null en plus plus in doit être unique
     */
    @Column(nullable = false, unique = true) 
    private String name;
    
    /**
     * Chaque application doit avoir une description
     */
    @Column(nullable = false)
    private String description;
     
    @OneToOne(mappedBy = "application", cascade = CascadeType.ALL)
    private ApiKey apiKey;
    
    @ManyToOne
    private Account acount;    

// Permet de savoir si l'application est toujours disponible
    private boolean isEnable;
    
    @OneToMany(mappedBy = "application", cascade = CascadeType.ALL)
    private List <EndUser> endUsers;   
   
    public Application(String name, String description, ApiKey apiKey, Account acount, boolean isEnable) {
        this.name = name;
        this.description = description;
        this.apiKey = apiKey;
        this.acount = acount;
        this.isEnable = isEnable;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ApiKey getApiKey() {
        return apiKey;
    }

    public void setApiKey(ApiKey apiKey) {
        this.apiKey = apiKey;
    }

    public Account getAcount() {
        return acount;
    }

    public void setAcount(Account acount) {
        this.acount = acount;
    }

    public boolean isEnable() {
        return isEnable;
    }

    public void setIsEnable(boolean isEnable) {
        this.isEnable = isEnable;
    }

    public List<EndUser> getEndUsers() {
        return endUsers;
    }

    public void setUser(List<EndUser> endUsers) {
        this.endUsers = endUsers;
    }
    
}
