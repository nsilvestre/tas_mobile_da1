package com.company.test.steps.CLIENT;

import com.company.framework.utils.Context;
import com.company.test.pages.CLIENT_iOS.EatsaUtilsPage;
import cucumber.api.java.en.And;
import io.appium.java_client.AppiumDriver;

public class UtilsSteps {

    private AppiumDriver driver;
    private final Context context;
    private EatsaUtilsPage eatsaUtilsPage;

    public UtilsSteps(Context context){
        this.context = context;
        driver = (AppiumDriver) context.getValue("driver");
        eatsaUtilsPage = new EatsaUtilsPage(driver);
    }

    public static String randomNumber() {
        int randomNumber = (int) (Math.random() * 9000) + 1000;
        return String.valueOf(randomNumber);
    }


    @And("^I go back$")
    public void iGoBack(){
        eatsaUtilsPage.goBack();
    }


    @And("^I navigate to the cart$")
    public void iNavigateToTheCart() {
        eatsaUtilsPage.navigateToCart();
    }
}
