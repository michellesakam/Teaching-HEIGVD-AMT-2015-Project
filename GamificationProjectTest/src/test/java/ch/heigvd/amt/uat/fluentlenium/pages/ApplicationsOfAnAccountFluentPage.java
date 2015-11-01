/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.amt.uat.fluentlenium.pages;

import static org.assertj.core.api.Assertions.assertThat;

/**
 *
 * @author Samira
 */
public class ApplicationsOfAnAccountFluentPage extends AbstractGamificationProjectFluentPage {

    private final static String buttonLogout = "#blogout"; // 
    private final static String buttonRegisterNewApp = "#bregisternewapp";
    private final static String buttonEdit = "#edit1";
    private final static String button = "#edit1";
    private final static String Account = "#Account";
    private final static String Application = "#App";
    private final static String Name = "#Name";
    private final static String Description = "#Description";
    private final static String LinkEndUser = "#linkEndUsers1";

    @Override
    public void isAt() {
        assertThat(title()).isEqualTo("Your Apps");
    }

    public String getUrl() {
        return "/pages/yourApps";
    }

    public void clickLogout() {
        click(buttonLogout);
    }

    public void clickRegisterNewApp() {
        click(buttonRegisterNewApp);
    }

    public void clickEdit() {
        click(buttonEdit);
    }

    public void clickEndUser() {
        click(LinkEndUser);
    }

    public void isEditedInTheNamePart(String name) {
        assertThat(findFirst(Name).getText()).isEqualTo(name);
    }

    public void isEditedInTheDescriptionPart(String description) {
        assertThat(findFirst(Description).getText()).isEqualTo(description);
    }

    public void isNotSaveTheModificationInDescriptionPart(String description) {
        assertThat(findFirst(Description).getText()).isNotEqualTo(description);
    }

    public void isNotSaveTheModificationInNamePart(String name) {
        assertThat(findFirst(Name).getText()).isNotEqualTo(name);
    }
    
    public void isCreated(String name) {
        assertThat(find(Name).getText()).isEqualTo(name);
    }

}
