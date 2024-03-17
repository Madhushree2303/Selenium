package com.testingselenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class Testcase06_vmoAppNavigateMethod {

    @Test
    public void maximizeAppVmo(){

        WebDriver driver;
        driver=new ChromeDriver();

        driver.get("https://app.vwo.com/#/login");

        driver.navigate().to("https://www.saucedemo.com/inventory.html");

        driver.navigate().back();
        driver.navigate().forward();
        driver.navigate().refresh();

    }

}
