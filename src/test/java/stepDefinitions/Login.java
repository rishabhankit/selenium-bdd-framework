package stepDefinitions;

import PageObjectPages.*;
import io.cucumber.java.en.When;

public class Login {

    TextContext textContext;
    PageObjectManager pageObjectManager;
    IRCTC irctc;


    public Login(TextContext textContext) {
        this.textContext = textContext;

        this.pageObjectManager = textContext.pageObjectManager;
        this.irctc = pageObjectManager.getIRCTC();
    }

    @When("^I fetch PNR label$")
    public void iFetchPNRLabel() {
        StepTracker.stepName.set("When I fetch PNR label");

        irctc.getPNR();

    }

    @When("I fetch Charts label")
    public void iFetchChartsLabel() {
        StepTracker.stepName.set("When I fetch Charts label");

        irctc.getChart();

    }
}

