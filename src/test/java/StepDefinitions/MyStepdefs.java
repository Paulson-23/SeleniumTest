package StepDefinitions;
import org.example.Dashboard;
import org.example.LoginPage;
import org.example.LoginPage.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.time.Duration;

import static DriverFactory.Driver.getDriver;

public class MyStepdefs {
    LoginPage loginPage = new LoginPage();
    @Given("I am on the HRM login page")
    public void iAmOnTheHRMLoginPage() {
        loginPage.navigateToUrl();
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @When("I enter the valid username {string}")
    public void iEnterTheValidUsername(String arg0) throws InterruptedException {
        loginPage.enterUsername(arg0);
    }

    @And("I enter the valid password {string}")
    public void iEnterTheValidPassword(String arg0) throws InterruptedException {
        LoginPage loginPage=new LoginPage();
        loginPage.enterPassword(arg0);
    }

    @And("I click on the login button")
    public void iClickOnTheLoginButton() {
        loginPage.login();
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @Then("I should be redirected to the OrangeHRM dashboard")
    public void iShouldBeRedirectedToTheOrangeHRMDashboard() throws InterruptedException {
        Dashboard dashboard = new Dashboard();
        dashboard.validateText();
    }

    @And("I enter the invalid password {string}")
    public void iEnterTheInvalidPassword(String arg0) throws InterruptedException {
        loginPage.enterPassword(arg0);
    }

    @Then("The {string} Error message should be displayed")
    public void theErrorMessageShouldBeDisplayed(String arg0) {
        loginPage.checkErrorMessage(arg0);
    }
}
