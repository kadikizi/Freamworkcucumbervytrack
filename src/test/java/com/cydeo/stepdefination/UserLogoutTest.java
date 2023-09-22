package com.cydeo.stepdefination;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class UserLogoutTest {

    private WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized"); // Tarayıcıyı tam ekran aç
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void testUserLogout() throws InterruptedException {

        driver.get("http://qa.xfleetsolutions.com/");
        WebElement usernameInput = driver.findElement(By.id("username"));
        WebElement passwordInput = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("login-button"));

        usernameInput.sendKeys("kullanici_adi");
        passwordInput.sendKeys("parola");
        loginButton.click();


        WebElement logoutButton = driver.findElement(By.id("logout-button"));
        logoutButton.click();



        WebElement backButton = driver.findElement(By.id("back-button"));
        Assert.assertFalse(backButton.isEnabled());


        ((JavascriptExecutor) driver).executeScript("window.open()");


        List<String> tabs = new java.util.ArrayList<>(driver.getWindowHandles());
        for (String tab : tabs) {
            driver.switchTo().window(tab);
            driver.navigate().back();
        }


        Thread.sleep(180000); // 3 dakika beklemek için
        WebElement loggedInMessage = driver.findElement(By.id("logged-in-message"));
        Assert.assertFalse(loggedInMessage.isDisplayed()); // Oturum kapatıldığını doğrula
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
