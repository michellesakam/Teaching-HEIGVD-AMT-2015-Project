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
    
    
    
    @Override
  public void isAt() {
    assertThat(title()).isEqualTo("App details");
  }
  
  

  public String getUrl() {
    return "/pages/applicationDetails";
  }
    
}
