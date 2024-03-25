package com.testingselenium.miniProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

public class CURA_HealthCare_App {

    WebDriver driver;

    @BeforeTest
    public void openBrowser(){
        ChromeOptions chromeOptions =new ChromeOptions();
        chromeOptions.addArguments("--start-maximized");
        driver=new ChromeDriver(chromeOptions);

    }
    @Test(priority = 0)
    public void openAppAndVerifyTitle(){
        driver.get("https://katalon-demo-cura.herokuapp.com/");
        String title=driver.getTitle();
        Assert.assertEquals(title,"CURA Healthcare Service");
    }

    @Test(priority = 1)
    public void verifyMakeAppointmentButtonAvailable(){

        WebElement makeApp_Button=driver.findElement(By.xpath("//a[@id='btn-make-appointment']"));
        if (makeApp_Button.isDisplayed()){
            makeApp_Button.click();
            System.out.println("MakeAppointment is displayed");
        }else {
            System.out.println("MakeAppointment button not displayed");
        }

    }
    @Test(priority = 2)
    public void enterLoginDetails(){
        WebElement login_TextBox=driver.findElement(By.cssSelector("input#txt-username"));
        login_TextBox.sendKeys("John Doe");

        WebElement password_TextBox=driver.findElement(By.cssSelector("input#txt-password"));
        password_TextBox.sendKeys("ThisIsNotAPassword");

        WebElement login_button=driver.findElement(By.cssSelector("button#btn-login"));
        login_button.click();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        Assert.assertEquals(driver.getCurrentUrl(),"https://katalon-demo-cura.herokuapp.com/#appointment");
    }

    @Test(priority = 3)
    public void make_Appointment(){
        WebElement facility_dropdown=driver.findElement(By.cssSelector("select#combo_facility"));
        Select select=new Select(facility_dropdown);

        select.selectByIndex(2);

        WebElement none_Options=driver.findElement(By.cssSelector("input#radio_program_none"));
        none_Options.click();

        WebElement vist_DateElement=driver.findElement(By.cssSelector("input#txt_visit_date"));
        vist_DateElement.sendKeys("27/03/2024");

        WebElement comment_Element=driver.findElement(By.cssSelector("textarea#txt_comment"));
        comment_Element.sendKeys("Make new appointment for Seoul CURA Healthcare Center Facility with doctor Mr.Jone");

        WebElement book_ButtonElement=driver.findElement(By.cssSelector("button#btn-book-appointment"));
        book_ButtonElement.click();

        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);

        System.out.println(driver.findElement(By.cssSelector("div.col-xs-12>h2")).getText());
        Assert.assertEquals(driver.findElement(By.cssSelector("div.col-xs-12>h2")).getText(),"Appointment Confirmation");

    }

    @AfterTest
    public void close_Browser(){
        driver.quit();
    }
}
