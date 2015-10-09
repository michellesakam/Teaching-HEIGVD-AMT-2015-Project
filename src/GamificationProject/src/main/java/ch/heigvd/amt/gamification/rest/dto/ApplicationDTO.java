/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.amt.gamification.rest.dto;

/**
 *
 * @author parfait
 */
public class ApplicationDTO {

    // nom de l'application
    private String name;
 
    // description de l'application
    private String description;

    // l'application est-elle toujours disponible ?
    private boolean isAnable;

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

    public boolean isIsAnable() {
        return isAnable;
    }

    public void setIsAnable(boolean isAnable) {
        this.isAnable = isAnable;
    }

}
