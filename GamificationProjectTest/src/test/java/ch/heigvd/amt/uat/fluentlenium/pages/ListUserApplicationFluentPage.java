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
public class ListUserApplicationFluentPage extends AbstractGamificationProjectFluentPage{
    
      @Override
  public void isAt() {
    assertThat(title()).isEqualTo("List of user of Appilcation");
  }
    
 
  @Override
  public String getUrl() {
    return "pages/listUsersApp";
  }
}
