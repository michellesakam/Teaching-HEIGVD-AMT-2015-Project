/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.amt.gamification.model;

import java.util.Date;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author parfait
 */
@Entity
@Table(name="Award")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="")
public abstract class Award  extends AbstractDomainModelEntity<Long>{
    private String raison;
   
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateReception;
    
    @ManyToOne
    private EndUser endUser; 

    /**
     * @return the raison
     */
    public String getRaison() {
        return raison;
    }

    /**
     * @param raison the raison to set
     */
    public void setRaison(String raison) {
        this.raison = raison;
    }

    /**
     * @return the dateReception
     */
    public Date getDateReception() {
        return dateReception;
    }

    /**
     * @param dateReception the dateReception to set
     */
    public void setDateReception(Date dateReception) {
        this.dateReception = dateReception;
    }

    /**
     * @return the endUser
     */
    public EndUser getEndUser() {
        return endUser;
    }

    /**
     * @param endUser the endUser to set
     */
    public void setEndUser(EndUser endUser) {
        this.endUser = endUser;
    }

}
