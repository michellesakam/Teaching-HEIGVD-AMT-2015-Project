package ch.heigvd.amt.uat.fluentlenium.pages;

import org.fluentlenium.core.FluentPage;
import org.openqa.selenium.WebDriver;

/*
 * @author Samira Kouchali
 */
public abstract class AbstractGamificationProjectFluentPage extends FluentPage {
private final static String Application = "#linkApp";
private final static String Account = "#linkAccount";

public void clickApplication() {
        click(Application);
    }
public void clickAccount() {
        click(Account);
    }
  
}
