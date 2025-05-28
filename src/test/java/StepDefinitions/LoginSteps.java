package StepDefinitions;
import lombok.extern.slf4j.Slf4j;
import org.example.Dashboard;
import org.example.LoginPage;
import org.example.LoginPage.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import java.time.Duration;

import static DriverFactory.Driver.getDriver;

@Slf4j
public class LoginSteps {
    LoginPage loginPage = new LoginPage();
    Dashboard dashboard = new Dashboard();
    @Given("I am on the HRM login page")
    public void iAmOnTheHRMLoginPage() {
        loginPage.navigateToUrl();
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @When("I enter the valid username {string}")
    public void iEnterTheValidUsername(String username) throws InterruptedException {
        loginPage.enterUsername(username);
    }

    @And("I enter the valid password {string}")
    public void iEnterTheValidPassword(String password) throws InterruptedException {
        loginPage.enterPassword(password);
    }

    @And("I click on the login button")
    public void iClickOnTheLoginButton() {
        loginPage.login();
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @Then("I should be redirected to the OrangeHRM dashboard")
    public void iShouldBeRedirectedToTheOrangeHRMDashboard() throws InterruptedException {
        loginPage.loginCheck();
    }

    @And("I enter the invalid password {string}")
    public void iEnterTheInvalidPassword(String password) throws InterruptedException {
        loginPage.enterPassword(password);
    }

    @Then("The {string} Error message should be displayed")
    public void theErrorMessageShouldBeDisplayed(String arg0) {
        loginPage.checkErrorMessage(arg0);
    }
}
