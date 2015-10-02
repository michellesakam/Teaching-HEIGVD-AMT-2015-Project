/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.amt.uat.selenium.pages;

import org.openqa.selenium.WebDriver;

/**
 *
 * @author Samira
 */
public class YourAppPage extends AbstractGamificationProject{

    public YourAppPage(WebDriver driver) {
        super(driver);
        
         // Check that we're on the right page.
    if (!"Your apps".equals(driver.getTitle())) {
      throw new IllegalStateException("This is not the correct page");
    }
    }
    
}
