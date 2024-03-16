package com.testingselenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Test01 {
    @Test
    public void openGoogle(){

        WebDriver driver = new ChromeDriver();
        driver.get("https://google.com");

    }
}
