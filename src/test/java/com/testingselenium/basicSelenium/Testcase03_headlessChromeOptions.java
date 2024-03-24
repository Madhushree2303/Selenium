package com.testingselenium.basicSelenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class Testcase03_headlessChromeOptions {

    @Test
    public void headlessTest(){
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--headless");
        WebDriver driver=new ChromeDriver(chromeOptions);

        driver.get("https://www.saucedemo.com/inventory.html");

        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());

        driver.quit();
    }
}

