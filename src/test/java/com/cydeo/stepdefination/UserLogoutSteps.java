package com.cydeo.stepdefination;

import com.cydeo.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.Assert;

public class UserLogoutSteps {

    @Given("User is logged in")
    public void user_is_logged_in() {

    }

    @Given("User is on the profile page")
    public void user_is_on_the_profile_page() {

    }

    @When("User clicks the logout button")
    public void user_clicks_the_logout_button() {

        WebElement logoutButton = Driver.getDriver().findElement(By.id("logoutButton"));
        logoutButton.click();
    }

    @Then("User is redirected to the Login page")
    public void user_is_redirected_to_the_login_page() {

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        WebElement loginPageElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("login-page")));


        Assert.assertTrue("Kullanıcı giriş sayfasına yönlendirilmedi.", loginPageElement.isDisplayed());
    }
}
