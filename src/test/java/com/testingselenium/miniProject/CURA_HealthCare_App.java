package com.testingselenium.miniProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

public class CURA_HealthCare_App {
    ChromeOptions chromeOptions;
    WebDriver driver;

    @BeforeTest
    public void openBrowser(){
        chromeOptions=new ChromeOptions();
        chromeOptions.addArguments("--start-maximized");
        driver=new ChromeDriver(chromeOptions);
    }
    @Test(priority = 0)
    public void openApp(){
        driver.get("https://katalon-demo-cura.herokuapp.com/");
        WebElement makeApp_Button=driver.findElement(By.xpath("//a[@id='btn-make-appointment']"));
        makeApp_Button.click();
    }
    @Test(priority = 1)
    public void enterLoginDetails(){
        WebElement login_TextBox=driver.findElement(By.cssSelector("input#txt-username"));
        login_TextBox.sendKeys("John Doe");

        WebElement password_TextBox=driver.findElement(By.cssSelector("input#txt-password"));
        password_TextBox.sendKeys("ThisIsNotAPassword");

        WebElement login_button=driver.findElement(By.cssSelector("button#btn-login"));
        login_button.click();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        Assert.assertEquals(driver.getTitle(),"CURA Healthcare Service");
    }

    @Test(priority = 2)
    public void make_Appointment(){
        WebElement facility_dropdown=driver.findElement(By.cssSelector("select#combo_facility"));
        Select select=new Select(facility_dropdown);

        select.selectByIndex(2);

        WebElement none_Options=driver.findElement(By.cssSelector("input#radio_program_none"));
        none_Options.click();
    }

    @BeforeTest
    public void close_Browser(){
        driver.quit();
    }
}