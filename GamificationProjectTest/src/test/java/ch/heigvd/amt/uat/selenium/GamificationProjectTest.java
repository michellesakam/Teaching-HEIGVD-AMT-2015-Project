/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.amt.uat.selenium;


//import ch.heigvd.amt.uat.selenium.pages.AboutPage;
//import ch.heigvd.amt.uat.selenium.pages.HomePage;
//import ch.heigvd.amt.uat.selenium.pages.LoginPage;
import ch.heigvd.amt.uat.selenium.pages.AccountRegistrationPage;
import ch.heigvd.amt.uat.selenium.pages.LoginPage;
import ch.heigvd.amt.uat.selenium.pages.YourAppPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 *
 * @author Samira
 */

public class GamificationProjectTest{
private String baseUrl = "localhost:8080/GamificationProject/";
  private WebDriver driver;

  
    @Before
  public void openBrowser() {
    driver = new FirefoxDriver();
  
  }
  /*
   @Test
  public void itShouldNotBePossibleToSigninWithAnInvalidEmail() {
    driver.get(baseUrl);
    LoginPage loginPage = new LoginPage(driver);
    loginPage.typeEmailAddress("this is not a valid email address");
    loginPage.typePassword("any password");
    loginPage.submitFormExpectingFailure();
  }
    
   @Test
  public void successfulSigninShouldBringUserToHomePage() {
    driver.get(baseUrl);
    LoginPage loginPage = new LoginPage(driver);
    loginPage.typeEmailAddress("a@a.com");
    loginPage.typePassword("any password");
   YourAppPage yourapppage = (YourAppPage)loginPage.submitForm(YourAppPage.class);
  }
  
 @Test
  public void ClickCreateAccountButtonShouldBringUserToAccountRegistrationPage() {
    driver.get(baseUrl);
    LoginPage loginPage = new LoginPage(driver);
    
   AccountRegistrationPage accountregistrationpage = (AccountRegistrationPage)loginPage.submitForm(AccountRegistrationPage.class);
  }
  
  /*
  
   @Test
  public void successfulCreatAccountShouldBringUserToyourAppPage() {
    driver.get(baseUrl + "/pages/yourApps");
    AccountRegistrationPage creatAccountPage = new AccountRegistrationPage(driver);
    creatAccountPage.typeEmailAddress("a@a.com");
    creatAccountPage.typeFirstname("any firstname");
    creatAccountPage.typeLastname("any lastname");
    creatAccountPage.typeLastname("any lastname");
    creatAccountPage.typePassword("any password");
    creatAccountPage.typeConfirmPassword("any password");
    YourAppPage yourapppage = (YourAppPage)creatAccountPage.submitForm(YourAppPage.class);
  }
*/
}