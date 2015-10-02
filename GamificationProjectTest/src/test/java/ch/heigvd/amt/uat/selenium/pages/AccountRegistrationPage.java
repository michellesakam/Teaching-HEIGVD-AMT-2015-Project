/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.amt.uat.selenium.pages;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 *
 * @author Samira
 */
public class AccountRegistrationPage extends AbstractGamificationProject {

     By EmailLocator = By.id("Email");
     By FristnameLocator = By.id("First_name");
     By LastnameLocator = By.id("Last_name");
     By PasswordLocator = By.id("Password");
     By ConfirmPasswordLocator = By.id("ConfirmPassword");
     By SignUpLocator = By.className("btn");
    
    
    
    public AccountRegistrationPage(WebDriver driver) {
        super(driver);
         if (!"Registration Page".equals(driver.getTitle())) {
      throw new IllegalStateException("This is not the correct page");
    }
        
    }

    public AccountRegistrationPage typeEmailAddress(String email) {
        driver.findElement(EmailLocator).sendKeys(email);
        return this;
    }

    public AccountRegistrationPage typeFirstname(String firstname) {
        driver.findElement(FristnameLocator).sendKeys(firstname);
        return this;
    }
    public AccountRegistrationPage typeLastname(String lastname) {
         driver.findElement(LastnameLocator).sendKeys(lastname);
        return this;
    }
    public AccountRegistrationPage typePassword(String password) {
       driver.findElement(PasswordLocator).sendKeys(password);
        return this;
    }
    public AccountRegistrationPage typeConfirmPassword(String any_password) {
        driver.findElement(PasswordLocator).sendKeys(any_password);
        return this;
    }
    
    public Page submitForm(Class<? extends Page> expectedPageClass) {
    driver.findElement(SignUpLocator).click();
    Page targetPage = null;
    try {
      targetPage = expectedPageClass.getConstructor(WebDriver.class).newInstance(driver);
    } catch (Exception ex) {
      Logger.getLogger(LoginPage.class.getName()).log(Level.SEVERE, null, ex);
      throw new RuntimeException("Exception when using reflection: " + ex.getMessage());
    }
    return targetPage;
  }
}
