package com.cydeo.utilities;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class BrowserUtils {
    public static void sleep(int second) {
        second *= 1000;

        try {
            Thread.sleep(second);
        } catch (InterruptedException e) {

        }
    }

    public static void switchWindowAndVerify(String expectedURL, String expectedTitle) {
        Set<String> allWindowsHandles = Driver.getDriver().getWindowHandles();

        for (String windowHandle : allWindowsHandles) {
            Driver.getDriver().switchTo().window(windowHandle);

            System.out.println("driver.getCurrentUrl() = " + Driver.getDriver().getCurrentUrl());

            if (Driver.getDriver().getCurrentUrl().contains(expectedURL)) {
                break;
            }
        }

        String actualTitle = Driver.getDriver().getTitle();

        Assert.assertTrue(actualTitle.contains(expectedTitle));
    }

    public static void verifyTitle(String expectedTitle) {
        Assert.assertEquals(Driver.getDriver().getTitle(), expectedTitle);
    }
    public static void verifyUrlContains(String expectedUrl) {

        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains(expectedUrl));

    }

    //return Dropdown all options convert to List of String
    public static List<String> dropdownOptionsWebElementToString(WebElement dropDownWebElment) {
        Select select = new Select(dropDownWebElment);
        List<WebElement> actualOptioAsWebElement = select.getOptions();

        List<String> actualOptionsAsString = new ArrayList<>();

        for (WebElement each : actualOptioAsWebElement) {
            actualOptionsAsString.add(each.getText());
        }
        return actualOptionsAsString;
    }

    /**

     clik radio button
     @param radioButtons
     @param atributedValue*/
    public static void  clickRadioButton(List<WebElement> radioButtons,String atributedValue){


        for (WebElement each : radioButtons) {

            if (each.getAttribute("value").equalsIgnoreCase(atributedValue))
                each.click();
        }
    }
}