package ch.heigvd.amt.uat.fluentlenium.pages;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * This class is used to test the "Login" page in the MVCDemo app.
 *
 * @author Olivier Liechti
 */
public class LoginFluentPage extends AbstractGamificationProjectFluentPage {

  private final static String inputLogin = "#login"; // id in the html code
  private final static String inputPassword = "#inputPassword"; // id in the html code
  private final static String buttonLogin = "#blogin"; // id in the html code
  private final static String buttonCreateAccount = "#bcreatAccount"; // id in the html code

  @Override
  public void isAt() {
    assertThat(title()).isEqualTo("Login Page");
  }

  public void typeEmailAddress(String login) {
    fill(inputLogin).with(login);
  }

  public void typePassword(String password) {
    fill(inputPassword).with(password);
  }

  public void clickLogin() {
    click(buttonLogin);
  }
  
  public void clickCreateAccount() {
    click(buttonCreateAccount);
  }

  public String getUrl() {
    return "/";
  }

}
