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
public class ApplicationDetailsFluentPage extends AbstractGamificationProjectFluentPage {
    private final static String inputName = "#Name"; // id in the html code
    private final static String inputDescription = "#Description"; // id in the html code
    private final static String buttonRegister = "#bregister"; // 
    private final static String buttonCancel = "#bcancel";
    
    
    @Override
  public void isAt() {
    assertThat(title()).isEqualTo("App details");
  }
  
  

  public String getUrl() {
    return "/pages/application?edit=true";
  }

   public void typeNameApp(String name) {
    fill(inputName).with(name);
  }

  public void typeDescriptionApp(String description) {
    fill(inputDescription).with(description);
  }
  
  
    public void clickRegister() {
        click(buttonRegister); 
    }
   
    public void clickcancel() {
        click(buttonCancel); 
    }
    
}
