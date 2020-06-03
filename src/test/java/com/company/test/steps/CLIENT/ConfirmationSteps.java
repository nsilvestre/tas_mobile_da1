package com.company.test.steps.CLIENT;

import com.company.framework.utils.Context;
import com.company.test.pages.CLIENT_iOS.ConfirmationPage;
import cucumber.api.java.en.Then;
import io.appium.java_client.AppiumDriver;

public class ConfirmationSteps {

    private final Context context;
    private AppiumDriver driver;
    private ConfirmationPage confirmationPage;

    public ConfirmationSteps(Context context){
        this.context = context;
        driver = (AppiumDriver) context.getValue("driver");
        confirmationPage = new ConfirmationPage(driver);
    }


    @Then("^the order is created$")
    public void theOrderIsCreated(){
        confirmationPage.tapConfirmationButton();
    }
}
