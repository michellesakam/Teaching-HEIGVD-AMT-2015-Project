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
public class AccountRegistrationFluentPage extends AbstractGamificationProjectFluentPage{
  
  private final static String inputEmail = "#Email"; // id in the html code
  private final static String inputFirstname = "#FirstName"; // id in the html code
  private final static String inputLastname = "#LastName"; // id in the html code
  private final static String inputPassword = "#Password"; // id in the html code
  private final static String inputConfirmPassword = "#ConfirmPassword"; // id in the html code
  private final static String buttonSigneUp = "#bSignUp"; // id in the html code

    @Override
  public void isAt() {
    assertThat(title()).isEqualTo("Registration Page");
  }
  
  
  public void typeEmailAddress(String email) {
    fill(inputEmail).with(email);
  }
  
  
  public void typeFirstname(String firstname) {
    fill(inputFirstname).with(firstname);
  }
  
  public void typeLastname(String lastname) {
    fill(inputLastname).with(lastname);
  }

  public void typePassword(String password) {
    fill(inputPassword).with(password);
  }
public void typeConfirmPassword(String password) {
    fill(inputConfirmPassword).with(password);
  }

  
  public void clickSignUp() {
    click(buttonSigneUp);
  }
  
  
  public String getUrl() {
    return "/pages/accountRegistration";
  }

}
