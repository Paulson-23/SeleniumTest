package StepDefinitions;
import lombok.extern.slf4j.Slf4j;
import org.Pages.Dashboard;
import org.Pages.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.time.Duration;

import static DriverFactory.Driver.getDriver;
import static Utilities.StepContext.setLogMessage;

public class LoginSteps {


    LoginPage loginPage = new LoginPage();
    Dashboard dashboard = new Dashboard();


    @Given("I am on the HRM login page")
    public void iAmOnTheHRMLoginPage() {
        loginPage.navigateToUrl();
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        setLogMessage("OrangeHRM Opened Successfully");
    }

    @When("I enter the valid username {string}")
    public void iEnterTheValidUsername(String username) throws InterruptedException {
        loginPage.enterUsername(username);
        setLogMessage("Username "+username+" is entered in the Username box");
    }

    @And("I enter the valid password {string}")
    public void iEnterTheValidPassword(String password) throws InterruptedException {
        loginPage.enterPassword(password);
        setLogMessage("Valid Password "+password+" is entered in the Password box");
    }

    @And("I click on the login button")
    public void iClickOnTheLoginButton() {
        loginPage.login();
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        setLogMessage("Login Button is Clicked");
    }

    @Then("I should be redirected to the OrangeHRM dashboard")
    public void iShouldBeRedirectedToTheOrangeHRMDashboard() throws InterruptedException {
        loginPage.loginCheck();
        setLogMessage("The OrangeHRM dashboard is opened");
    }

    @And("I enter the invalid password {string}")
    public void iEnterTheInvalidPassword(String password) throws InterruptedException {
        loginPage.enterPassword(password);
        setLogMessage("Invalid Password "+password+" is entered in the Password box");
    }

    @Then("The {string} Error message should be displayed")
    public void theErrorMessageShouldBeDisplayed(String error) {
        loginPage.checkErrorMessage(error);
        setLogMessage("Invalid Credentials error message should be displayed");
    }
}
