package ch.heigvd.amt.gamification.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author Raphaël Racine
 */
@Entity
public class Application implements Serializable {

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
    
    @OneToMany
    private List <EndUser> user;   
    
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private Long id;
   
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

    public List<EndUser> getUser() {
        return user;
    }

    public void setUser(List<EndUser> user) {
        this.user = user;
    }

   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }
}
