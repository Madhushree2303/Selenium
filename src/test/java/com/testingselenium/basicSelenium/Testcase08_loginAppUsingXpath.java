package com.testingselenium.basicSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Testcase08_loginAppUsingXpath {

    @Test
    public void enterLoginCredentials(){

        ChromeOptions chromeOptions=new ChromeOptions();
        chromeOptions.addArguments("--start-maximized");
        WebDriver driver=new ChromeDriver(chromeOptions);
        driver.get("https://www.saucedemo.com/");


        WebElement title_Ele=driver.findElement(By.xpath("//div[text()='Swag Labs']"));
        String title_name=title_Ele.getText();

        Assert.assertEquals(title_name,"Swag Labs");

        WebElement userName_textBox=driver.findElement(By.xpath("//input[@id='user-name']"));
        userName_textBox.sendKeys("standard_user");

        WebElement passWord_textBox=driver.findElement(By.xpath("//input[@id='password']"));
        passWord_textBox.sendKeys("secret_sauce");

        driver.findElement(By.xpath("//input[@id='login-button']")).click();

        Assert.assertEquals(driver.getCurrentUrl(),"https://www.saucedemo.com/inventory.html");


        //driver.close();
    }
}
