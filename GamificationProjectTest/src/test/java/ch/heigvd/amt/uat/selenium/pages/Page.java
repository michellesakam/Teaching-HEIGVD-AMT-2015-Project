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
public abstract class Page {
    final WebDriver driver;

  public Page(WebDriver driver) {
    this.driver = driver;
  }

}
    

