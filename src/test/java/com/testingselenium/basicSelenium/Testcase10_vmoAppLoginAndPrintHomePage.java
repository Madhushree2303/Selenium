package com.testingselenium.basicSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Testcase10_vmoAppLoginAndPrintHomePage {

    ChromeOptions chromeOptions;
    WebDriver driver;

    @BeforeTest
    public void openBrowser(){
        chromeOptions=new ChromeOptions();
        chromeOptions.addArguments("--start-maximized");
        driver=new ChromeDriver(chromeOptions);
    }
    @Test(priority = 0)
    public void navigateToVmoApp(){
        driver.get("https://app.vwo.com/#/login");
        Assert.assertEquals(driver.getTitle(),"Login - VWO");
    }

    @Test(priority = 1)
    public void enterLogindetails()  {
        WebElement user_input=driver.findElement(By.cssSelector("input#login-username"));
        user_input.sendKeys("madhu.balan023@gmail.com");

        WebElement password_input=driver.findElement(By.cssSelector("[name='password']"));
        password_input.sendKeys("Madhu@023");

        WebElement login_button=driver.findElement(By.cssSelector("button#js-login-btn"));
        login_button.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //Assert.assertEquals(driver.getTitle(),"Dashboard");

    }

    @Test(priority = 2)
    public void verifyHomepage(){

        WebElement dashboard_text=driver.findElement(By.cssSelector("[data-qa='lufexuloga']"));
        String text= dashboard_text.getText();
        System.out.println(text);
    }

    @AfterTest
    public void closeBrowser(){
        driver.close();
    }
}
