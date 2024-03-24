package com.testingselenium.basicSelenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class Testcase05_Vmomaximizescreen {

    @Test
    public void maximizeAppVmo(){

        ChromeOptions chromeOptions=new ChromeOptions();
        chromeOptions.addArguments("--start-maximized");

        WebDriver driver;
        driver=new ChromeDriver(chromeOptions);
        driver.get("https://google.com");

        driver.quit();
        driver=new EdgeDriver();
        driver.get("https://www.saucedemo.com/inventory.html");

    }
}
