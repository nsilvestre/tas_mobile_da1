package com.company.test.pages.ANDROID;

import com.company.framework.pageobject.NewMobileBasePO;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MainContactsPage extends NewMobileBasePO {

    private String addButtonId = "Create new contact";
    private String contactId = "Nicolas Silvestre";
    private String moreOptionsId = "More options";
    private String deleteXpath = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[2]/android.widget.RelativeLayout/android.widget.TextView";
    private String deleteAlertId = "android:id/button1";

    public void tapAdd() {
        waitDriver.until(ExpectedConditions.elementToBeClickable(MobileBy.AccessibilityId(addButtonId))).click();
    }

    public void selectContact() {
        waitDriver.until(ExpectedConditions.elementToBeClickable(MobileBy.AccessibilityId(contactId))).click();
    }

    public void tapMoreOptions() {
        waitDriver.until(ExpectedConditions.elementToBeClickable(MobileBy.AccessibilityId(moreOptionsId))).click();
    }

    public void tapDelete() {
        waitDriver.until(ExpectedConditions.elementToBeClickable(MobileBy.xpath(deleteXpath))).click();
    }

    public void tapDeleteFromAlert() {
        waitDriver.until(ExpectedConditions.elementToBeClickable(By.id(deleteAlertId))).click();
    }
}
