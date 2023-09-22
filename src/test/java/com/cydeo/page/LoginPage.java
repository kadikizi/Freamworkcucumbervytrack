package com.cydeo.page;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage() {
        PageFactory.initElements (Driver.getDriver(),this);

    }
    @FindBy (id="prependedInput")
    public WebElement Username;
    @FindBy(id="prependedInput2")
    public WebElement pasword;
    @FindBy(id="_submit")
    public WebElement loginbutton;

}
