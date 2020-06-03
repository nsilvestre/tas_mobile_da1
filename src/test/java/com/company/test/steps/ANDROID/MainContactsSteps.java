package com.company.test.steps.ANDROID;

import com.company.test.pages.ANDROID.MainContactsPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.When;

public class MainContactsSteps {

    private MainContactsPage mainContactsPage = new MainContactsPage();

    @When("^I tap Add button$")
    public void iTapAddButton(){
        mainContactsPage.tapAdd();
    }

    @When("^I select the contact$")
    public void iSelectTheContact() throws Throwable {
        mainContactsPage.selectContact();
    }

    @And("^I tap the menu$")
    public void iTapTheMenu() throws Throwable {
        mainContactsPage.tapMoreOptions();
    }

    @And("^I tap delete$")
    public void iTapDelete() throws Throwable {
        mainContactsPage.tapDelete();
    }

    @And("^I tap delete from the alert$")
    public void iTapDeleteFromTheAlert() throws Throwable {
        mainContactsPage.tapDeleteFromAlert();
    }
}


