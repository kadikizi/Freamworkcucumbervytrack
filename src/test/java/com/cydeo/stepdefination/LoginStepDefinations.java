package com.cydeo.stepdefination;

import com.cydeo.page.LoginPage;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.hc.core5.util.Asserts;
import org.junit.Assert;

public class LoginStepDefinations {
  LoginPage loginPage=new LoginPage();
    @Given("user is on login page")
    public void user_is_on_login_page() {
        Driver.getDriver().get("http://qa.xfleetsolutions.com/user/login");
    }
    @When("User enter to input username")
    public void user_enter_to_input_username() {
        loginPage.Username.sendKeys("User1");

    }
    @When("User enter to input password")
    public void user_enter_to_input_password() {
      loginPage.pasword.sendKeys("UserUser123");

    }
    @When("User clik to login button")
    public void user_clik_to_login_button() {
      loginPage.loginbutton.click();
      BrowserUtils.sleep(10);
    }
    @Then("Users see dasbord page")
    public void users_see_dasbord_page() {
      String expectedtitle="Dashboard";
      String Acualtitle=Driver.getDriver().getTitle();
      Assert.assertEquals(expectedtitle,Acualtitle);


    }


}
