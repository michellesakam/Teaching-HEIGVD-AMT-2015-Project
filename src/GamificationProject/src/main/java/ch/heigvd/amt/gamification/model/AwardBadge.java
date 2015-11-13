/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.amt.gamification.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 *
 * @author parfait
 */
@Entity
@DiscriminatorValue( "badge")
public class AwardBadge extends Award{  
    // contient le lien vers l'image qui contient le badge
    private String badge; 

    /**
     * @return the badge
     */
    public String getBadge() {
        return badge;
    }

    /**
     * @param badge the badge to set
     */
    public void setBadge(String badge) {
        this.badge = badge;
    }
}
