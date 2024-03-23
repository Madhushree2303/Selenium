package com.testingselenium;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Testcase09_logOutSwagLapApp {

    @Test
    public void logOutApp() throws InterruptedException {

        WebDriver driver=new ChromeDriver();
        driver.get("https://www.saucedemo.com/");

        WebElement title_Ele=driver.findElement(By.xpath("//div[text()='Swag Labs']"));
        String title_name=title_Ele.getText();

        WebElement userName_textBox=driver.findElement(By.xpath("//input[@id='user-name']"));
        userName_textBox.sendKeys("standard_user");

        WebElement passWord_textBox=driver.findElement(By.xpath("//input[@id='password']"));
        passWord_textBox.sendKeys("secret_sauce");

        driver.findElement(By.xpath("//input[@id='login-button']")).click();

        WebElement more_button=driver.findElement(By.xpath("//button[@id='react-burger-menu-btn']"));
        more_button.click();

        WebElement logout_button=driver.findElement(By.xpath("//a[@id='logout_sidebar_link']"));
        //logout_button.click();

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].click();", logout_button);

        Assert.assertEquals(driver.getCurrentUrl(),"https://www.saucedemo.com/");

    }
}
