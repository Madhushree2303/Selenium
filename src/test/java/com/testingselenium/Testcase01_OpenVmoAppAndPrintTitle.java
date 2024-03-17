package com.testingselenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Testcase01_OpenVmoAppAndPrintTitle {
    @Test
    public void openVmoApp() throws InterruptedException {

        //Open app.vmo
        WebDriver driver = new ChromeDriver();
        driver.get("https://app.vwo.com/#/login");
        //verify app.vmo title and current url
        Assert.assertEquals(driver.getTitle(),"Login - VWO");
        Assert.assertEquals(driver.getCurrentUrl(),"https://app.vwo.com/#/login");
        //Entering email id
        WebElement email_id=driver.findElement(By.xpath("//input[@id='login-username']"));
        email_id.sendKeys("admin@admin.com");
        //Entering password
        WebElement password=driver.findElement(By.id("login-password"));
        password.sendKeys("admin123");
        //Clicking on sign in button
        WebElement signin_button=driver.findElement(By.id("js-login-btn"));
        signin_button.click();

        try {
            Thread.sleep(3000);
        }catch (InterruptedException e){
            throw new RuntimeException(e);

        }

        //verifying error message for invalid user
        WebElement error_message=driver.findElement(By.id("js-notification-box-msg"));
        String message=error_message.getText();
        Assert.assertEquals(message,"Your email, password, IP address or location did not match");

        driver.quit();
    }
}
