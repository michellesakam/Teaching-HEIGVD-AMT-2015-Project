package ch.heigvd.amt.gamification.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 * 
 * @author Raphaël Racine
 */
@Entity
public class ApiKey extends AbstractDomainModelEntity<Long> implements Serializable {

   
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private Long id;
   
   @OneToOne
    private Application application;
   
   @Column(name = "kkey")
    private String key;
    public ApiKey() {
    }

   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   
   public Long getUsers(){
       return 0l;
   }


    public Application getApplication() {
        return application;
    }

    public void setApplication(Application application) {
        this.application = application;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
