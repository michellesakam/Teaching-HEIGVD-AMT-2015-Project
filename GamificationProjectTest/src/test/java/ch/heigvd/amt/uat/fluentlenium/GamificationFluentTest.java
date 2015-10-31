package ch.heigvd.amt.uat.fluentlenium;

import ch.heigvd.amt.uat.fluentlenium.pages.AccountRegistrationFluentPage;
import ch.heigvd.amt.uat.fluentlenium.pages.ApplicationRegistrationFluentPage;
import ch.heigvd.amt.uat.fluentlenium.pages.ApplicationsOfAnAccountFluentPage;
import ch.heigvd.amt.uat.fluentlenium.pages.ApplicationDetailsFluentPage;
import ch.heigvd.amt.uat.fluentlenium.pages.LoginFluentPage;
import org.fluentlenium.adapter.FluentTest;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.fluentlenium.core.annotation.Page;
import org.junit.After;

/**
 *
 * @author Samira Kouchali
 */
public class GamificationFluentTest extends FluentTest {

    private final String baseUrl = "http://localhost:8080/GamificationProject/";

    private static int newEmailId = 0;

    private void simulateLogin() {
        goTo(baseUrl);
        loginPage.isAt();
        loginPage.typeEmailAddress("raphael.racine@heig-vd.ch");
        loginPage.typePassword("toortoor");
        loginPage.clickLogin();
        yourAppPage.isAt();
    }
    
    @Page
    public LoginFluentPage loginPage;

    @Page
    public ApplicationsOfAnAccountFluentPage yourAppPage;

    @Page
    public AccountRegistrationFluentPage RegistrationPage;

    @Page
    public ApplicationRegistrationFluentPage ApplicationRegistrationPage;
    
    @Page
    public ApplicationDetailsFluentPage ApplicationDetailsPage;

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
    public void itShouldBePossibleToAccessRegistrationPagesWithClickSurCreateAccountButton() {
        goTo(baseUrl);
        loginPage.clickCreateAccount();
        RegistrationPage.isAt();
    }

    @Test
    public void itShouldNotBePossibleToSignUpWithAnInvalidEmail() {
        goTo(baseUrl + "pages/account?edit=false");
        RegistrationPage.isAt();
        
        RegistrationPage.typeEmailAddress("not a valid email");
        RegistrationPage.typeFirstname("FirstName");
        RegistrationPage.typeLastname("LastName");
        RegistrationPage.typePassword("11111111");
        RegistrationPage.typeConfirmPassword("11111111");
        RegistrationPage.clickSignUp();
        RegistrationPage.isAt();

    }

     @Test
    public void itShouldNotBePossibleToSignUpWithAnPasswordSmallerThan8Character() {
        goTo(baseUrl + "pages/account?edit=false");

        RegistrationPage.typeEmailAddress("a@b.ch");
        RegistrationPage.typeFirstname("FirstName");
        RegistrationPage.typeLastname("LastName");
        RegistrationPage.typePassword("toor");
        RegistrationPage.typeConfirmPassword("toor");
        RegistrationPage.clickSignUp();
        RegistrationPage.isAt();

    }
    
    @Test
    public void itShouldBePossibleToAccessYourAppsPagesWithCreateAnAccount() {
        goTo(baseUrl + "pages/account?edit=false");

        RegistrationPage.typeEmailAddress(newEmailId + "sara.kouch@gmail.ch");
        RegistrationPage.typeFirstname("Sara");
        RegistrationPage.typeLastname("Kouch");
        RegistrationPage.typePassword("12341234");
        RegistrationPage.typeConfirmPassword("12341234");
        RegistrationPage.clickSignUp();
        yourAppPage.isAt();
        // yourAppPage.clickLogout();

    }

    @Test
    public void itShouldBePossibleToSigninWithAnvalidEmail() {
        goTo(baseUrl);
        loginPage.isAt();
        loginPage.typeEmailAddress("raphael.racine@heig-vd.ch");
        loginPage.typePassword("toortoor");
        loginPage.clickLogin();
        yourAppPage.isAt();
        //   yourAppPage.clickLogout();

    }

    @Test
    public void itShouldNotBePossibleToCreateAnAccountWithEmailWhitchAlreadyExists() {
        goTo(baseUrl + "pages/account?edit=false");

        RegistrationPage.typeEmailAddress("raphael.racine@heig-vd.ch");
        RegistrationPage.typeFirstname("firstname");
        RegistrationPage.typeLastname("lastname");
        RegistrationPage.typePassword("12341234");
        RegistrationPage.typeConfirmPassword("12341234");
        RegistrationPage.clickSignUp();
        RegistrationPage.isAt();

    }

    @Test
    public void itShouldAllowTheUsersToRegisterNewApplication() {
        goTo(baseUrl);
        simulateLogin();
        yourAppPage.clickRegisterNewApp();
        ApplicationRegistrationPage.isAt();
    }

    @Test
    public void itShouldBePossibleToRegisterNewAppWithSubmitNecessaryInformations() {

        simulateLogin();
        yourAppPage.clickRegisterNewApp();
        ApplicationRegistrationPage.typeNameApp("Name of application");
        ApplicationRegistrationPage.typeDescriptionApp("This is a short description of the application");
        ApplicationRegistrationPage.clickRegister();
        yourAppPage.isAt();
    }

    @Test
    public void itShouldNotBePossibleToRegisterAnApplicationWhitchAlreadyExists() {

        simulateLogin();
        yourAppPage.clickRegisterNewApp();
        ApplicationRegistrationPage.typeNameApp("Lego Creator");
        ApplicationRegistrationPage.typeDescriptionApp("This is a short description of the application");
        ApplicationRegistrationPage.clickRegister();
        ApplicationRegistrationPage.isAt();
    }
    
 @Test
    public void itShouldBePossibleToEditAnApplication() {

        simulateLogin();
        yourAppPage.clickEdit();
        ApplicationDetailsPage.isAt();
    }
    
     @Test
    public void itShouldBePossibleToLogoutWithClickLogoutButton() {

        simulateLogin();   
        yourAppPage.clickLogout();
        loginPage.isAt();
        
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

    @After
    public void tearDown() {
        newEmailId++;
    }

}
