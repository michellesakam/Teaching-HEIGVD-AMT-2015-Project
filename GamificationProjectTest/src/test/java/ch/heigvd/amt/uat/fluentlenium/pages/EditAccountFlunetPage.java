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
public class EditAccountFlunetPage extends AbstractGamificationProjectFluentPage{
    

  private final static String inputPassword = "#Password"; // id in the html code
  private final static String inputConfirmPassword = "#ConfirmPassword"; 
  private final static String buttonConfirm = "#bSignUp"; 
  private final static String buttonCancel = "#bCancel"; 
  
    @Override
  public void isAt() {
    assertThat(title()).isEqualTo("Edit your account details");
  }
  
  public void typePassword(String password) {
    fill(inputPassword).with(password);
  }
public void typeConfirmPassword(String password) {
    fill(inputConfirmPassword).with(password);
  }

  
  public void clickConfirm() {
    click(buttonConfirm);
  }
  
  public void clickCancel() {
    click(buttonCancel);
  }
  
  @Override
  public String getUrl() {
    return "/pages/account?edit=true";
  }

    
    
}
