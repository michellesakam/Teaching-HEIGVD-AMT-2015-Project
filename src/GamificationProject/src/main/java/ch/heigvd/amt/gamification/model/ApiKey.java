
package ch.heigvd.amt.gamification.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;

/**
 * 
 * @author Parfait Noubissi
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "ApiKey.findByKey", query = "SELECT a FROM ApiKey a WHERE a.key = :key")
})

public class ApiKey extends AbstractDomainModelEntity<Long> {
   
   @OneToOne
    private Application application;
   
   @Column(name = "kkey")
    private String key;
    public ApiKey() {
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
