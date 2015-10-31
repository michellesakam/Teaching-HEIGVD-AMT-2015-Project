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
public class ApplicationRegistrationFluentPage extends AbstractGamificationProjectFluentPage {

    private final static String inputName = "#Name"; // id in the html code
    private final static String inputDescription = "#Description"; // id in the html code
    private final static String buttonRegister = "#bregister"; // 
    private final static String buttonCancel = "#bcancel";
     

    @Override
    public void isAt() {
        assertThat(title()).isEqualTo("Register New App");
    }

    public void typeNameApp(String name) {
    fill(inputName).with(name);
  }

  public void typeDescriptionApp(String description) {
    fill(inputDescription).with(description);
  }

    
    public String getUrl() {
        return "/pages/application?edit=false";
    }

    public void clickRegister() {
        click(buttonRegister);
    }

    public void clickCancel() {
        click(buttonCancel);
    }
}
