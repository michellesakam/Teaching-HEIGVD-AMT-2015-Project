package ch.heigvd.amt.uat.fluentlenium;

import ch.heigvd.amt.uat.fluentlenium.pages.AccountRegistrationFluentPage;
import ch.heigvd.amt.uat.fluentlenium.pages.ApplicationRegistrationFluentPage;
import ch.heigvd.amt.uat.fluentlenium.pages.ApplicationsOfAnAccountFluentPage;
import ch.heigvd.amt.uat.fluentlenium.pages.LoginFluentPage;
import org.fluentlenium.adapter.FluentTest;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.fluentlenium.core.annotation.Page;

/**
 *
 * @author Samira Kouchali
 */
public class GamificationFluentTest extends FluentTest {

    private final String baseUrl = "http://localhost:8080/GamificationProject/";

    @Page
    public LoginFluentPage loginPage;

    @Page
    public ApplicationsOfAnAccountFluentPage yourAppPage;

    @Page
    public AccountRegistrationFluentPage RegistrationPage;

    @Page
    public ApplicationRegistrationFluentPage ApplicationRegistrationPage;
    
    
     @Test
     public void itShouldNotBePossibleToSigninWithAnInvalidEmail() {
     goTo(baseUrl);
     loginPage.isAt();
     loginPage.typeEmailAddress("not a valid email");
     loginPage.typePassword("any password");
     loginPage.clickLogin();
     loginPage.isAt();
     }
    
   

     @Test
     public void itShouldBeNotPossibleToAccessSecurePagesWithoutLogin() {
     goTo(baseUrl + "/pages/yourApps");
     loginPage.isAt();
     }
    
     @Test
     public void itShouldBePossibleToAccessRegistrationPagesWithCreateAccountButton() {
     goTo(baseUrl);
     loginPage.clickCreateAccount();
     RegistrationPage.isAt();
     }
    
    
     @Test
     public void itShouldNotBePossibleToSignUpWithAnInvalidEmail() {
     goTo(baseUrl + "pages/accountRegistration");
     RegistrationPage.isAt();
       
     RegistrationPage.typeEmailAddress("not a valid email");
     RegistrationPage.typeFirstname("FirstName");
     RegistrationPage.typeLastname("LastName");
     RegistrationPage.typePassword("any password");
     RegistrationPage.typeConfirmPassword("any password");
     RegistrationPage.clickSignUp();
     RegistrationPage.isAt();
        
     }
    
    
     @Test
     public void itShouldBePossibleToAccessYoutAppsPagesWithCreateAnAccount() {
       
     goTo(baseUrl + "pages/accountRegistration");
     RegistrationPage.isAt();
       
     RegistrationPage.typeEmailAddress("sara.kouch@gmail.ch");
     RegistrationPage.typeFirstname("Sara");
     RegistrationPage.typeLastname("Kouch");
     RegistrationPage.typePassword("1234");
     RegistrationPage.typeConfirmPassword("1234");
     RegistrationPage.clickSignUp();
     yourAppPage.isAt();
     // yourAppPage.clickLogout();
        
     }
     @Test
     public void itShouldBePossibleToSigninWithAnvalidEmail() {
     goTo(baseUrl);
     loginPage.isAt();
     loginPage.typeEmailAddress("sara.kouch@gmail.ch");
     loginPage.typePassword("1234");
     loginPage.clickLogin();
     yourAppPage.isAt();
     //   yourAppPage.clickLogout();
        
     }
    
    
     @Test
     public void itShouldNotBePossibleToSignUpWithEmailThatIsNotUnique() {
     goTo(baseUrl + "pages/accountRegistration");
      
     RegistrationPage.typeEmailAddress("raphael.racine@heig-vd.ch");
     RegistrationPage.typeFirstname("firstname");
     RegistrationPage.typeLastname("lastname");
     RegistrationPage.typePassword("1234");
     RegistrationPage.typeConfirmPassword("1234");
     RegistrationPage.clickSignUp();
     RegistrationPage.isAt();
        
     }
    
     

    @Test
    public void itShouldAllowTheUsersToRegisterNewApplication() {
        goTo(baseUrl);

        loginPage.typeEmailAddress("sara.kouch@gmail.ch");
        loginPage.typePassword("1234");
        loginPage.clickLogin();
        yourAppPage.clickRegisterNewApp();

        ApplicationRegistrationPage.isAt();
    }

    @Test
    public void itShouldBePossibleToRegisterNewAppWithSubmitNecessaryInformations() {

        goTo(baseUrl);
        loginPage.typeEmailAddress("sara.kouch@gmail.ch");
        loginPage.typePassword("1234");
        loginPage.clickLogin();
        yourAppPage.clickRegisterNewApp();

        ApplicationRegistrationPage.typeNameApp("Name of application");
        ApplicationRegistrationPage.typeDescriptionApp("This is a short description of the application");
        ApplicationRegistrationPage.clickRegister();
        yourAppPage.isAt();
    }
    
    @Test
    public void itShouldNotBePossibleToRegisterAnApplicationWitchAlreadyExists() {

        goTo(baseUrl);
        loginPage.typeEmailAddress("raphael.racine@heig-vd.ch");
        loginPage.typePassword("toor");
        loginPage.clickLogin();
        yourAppPage.clickRegisterNewApp();

        ApplicationRegistrationPage.typeNameApp("Lego Creator");
        ApplicationRegistrationPage.typeDescriptionApp("This is a short description of the application");
        ApplicationRegistrationPage.clickRegister();
        ApplicationRegistrationPage.isAt();
    }

    
    
    
    @Override
    public WebDriver getDefaultDriver() {
        return new FirefoxDriver();
        //System.setProperty("webdriver.chrome.driver", "/Users/admin/Downloads/chromedriver");
        //return new ChromeDriver();
    }

    @Override
    public String getDefaultBaseUrl() {
        return baseUrl;
    }

}
