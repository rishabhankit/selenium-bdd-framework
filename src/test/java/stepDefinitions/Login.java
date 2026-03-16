package stepDefinitions;

import PageObjectPages.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Login {

    TextContext textContext;
    PageObjectManager pageObjectManager;
    SwagLabsLoginDashboard swagLabsLoginDashboard;
    SwagLabsHomePage swagLabsHomePage;


    public Login(TextContext textContext) {
        this.textContext = textContext;

        this.pageObjectManager = textContext.pageObjectManager;
        this.swagLabsLoginDashboard = pageObjectManager.getSwagLabsLoginDashboard();
        this.swagLabsHomePage=pageObjectManager.getSwagLabsHomePage();
    }





    @When("I Enter {string} and {string}")
    public void iEnterAnd(String username, String password) {

        StepTracker.stepName.set("When I Enter Username and Password");
        this.swagLabsLoginDashboard.enterUsernamePassword(username, password);


    }

    @And("I click on login button")
    public void iClickOnLoginButton() {
        StepTracker.stepName.set("And I click on login button");
        this.swagLabsLoginDashboard.submitButton();
    }

    @Then("I verify SwagLabs home page")
    public void iVerifySwagLabsHomePage() {

        StepTracker.stepName.set("I verify SwagLabs home page");
        this.swagLabsHomePage.verifyHomePage();


    }

    @And("I get all product names")
    public void iGetAllProductNames() {

        StepTracker.stepName.set("And I get all product names");
        this.swagLabsHomePage.getAllProductNames();

    }
}

