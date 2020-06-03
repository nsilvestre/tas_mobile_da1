package com.company.test.pages.CLIENT_iOS;

import com.company.framework.constants.ClientCons;
import com.company.framework.pageobject.MobileBasePO;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.HashMap;
import java.util.Map;

public class PartnersPage extends MobileBasePO {

    private String rStage = "https://api.r-stage..com";
    private String wStage = "https://api.w-stage.com";
    private String errorButtonId = "Errors";
    private String tableClass = "XCUIElementTypeTable";

    public PartnersPage(AppiumDriver driver) {
        super(driver);
    }


    public void selectPartner() {
        getWaitDriver().until(ExpectedConditions.elementToBeClickable((By.id(rStage)))).click();
        getWaitDriverLong().until(ExpectedConditions.invisibilityOfElementLocated(By.id(errorButtonId)));
    }


    public void selectPartner(String partner){
        switch(partner){
            case "R":
                getWaitDriverLong().until(ExpectedConditions.elementToBeClickable((By.id(ClientCons.RStageURL)))).click();
                getWaitDriverLong().until(ExpectedConditions.invisibilityOfElementLocated(By.id(errorButtonId)));
            break;
            case "W":
                getWaitDriverLong().until(ExpectedConditions.elementToBeClickable((By.id(ClientCons.WStageURL)))).click();
                getWaitDriverLong().until(ExpectedConditions.invisibilityOfElementLocated(By.id(errorButtonId)));
            break;
            case "iOS":
                //Scroll down to make iOS visible
                IOSElement main = (IOSElement) getWaitDriver().until(ExpectedConditions.elementToBeClickable((By.className(tableClass))));

                Map<String, Object> args = new HashMap<>();
                args.put("element", main.getId());
                args.put("direction", "down");
                getDriver().executeScript("mobile: scroll", args);

                getWaitDriverLong().until(ExpectedConditions.elementToBeClickable((By.id(ClientCons.EStageURL)))).click();
                getWaitDriverLong().until(ExpectedConditions.invisibilityOfElementLocated(By.id(errorButtonId)));
            break;
        }

        ClientCons.CURRENT_PARNER = partner;
    }
}
