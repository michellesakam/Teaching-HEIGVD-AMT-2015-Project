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
  
}
