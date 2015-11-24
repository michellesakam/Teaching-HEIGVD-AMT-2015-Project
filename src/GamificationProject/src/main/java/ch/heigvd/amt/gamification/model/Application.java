package ch.heigvd.amt.gamification.model;

import java.util.LinkedList;
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
 * @author Parfait Noubissi
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Application.numberOfApplications", query = "SELECT COUNT(a) FROM Application a"),
    @NamedQuery(name = "Application.findAll", query = "SELECT a FROM Application a"),
    @NamedQuery(name = "Application.findByAccountWithEndUsersNumber",
            query = "SELECT a, COUNT(e) "
                    + "FROM Application a LEFT JOIN a.endUsers e "
                    + "WHERE a.acount.id = :idAccount GROUP BY a.id"),
    @NamedQuery(name = "Application.nbEndUsersOfApplication", query= "SELECT COUNT(e) FROM EndUser e WHERE e.application.id = :idApplication"),
    @NamedQuery(name = "Application.findEndUsers", query = "SELECT e FROM EndUser e WHERE e.application.id = :idApplication"),
    @NamedQuery(name = "Application.findByApiKey", query = "SELECT a FROM Application a WHERE a.apiKey.key = :key"),
    @NamedQuery(name = "Application.checkEndUserUseApp", query = "SELECT e FROM EndUser e WHERE e.application = :app AND e = :endUser")
})

public class Application extends AbstractDomainModelEntity<Long> {
    
    @OneToMany(mappedBy = "application")
    private List<Level> levels;

    public Application() {}

    @Column(nullable = false, unique = true) 
    private String name;
    

    @Column(nullable = false)
    private String description;
     
    @OneToOne(mappedBy = "application", cascade = CascadeType.ALL)
    private ApiKey apiKey;
    
    @ManyToOne
    private Account acount;    

    
    private boolean isEnable;
    
    @OneToMany(mappedBy = "application", cascade = CascadeType.ALL)
    private List<EndUser> endUsers;
   
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

    public boolean getIsEnable() {
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

    public List<Level> getLevels() {
        return levels;
    }

    public void setLevels(List<Level> levels) {
        this.levels = levels;
    }
    
    
    
}
