package com.testingselenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.io.File;

public class Testcase02_addBlockerExtenstionToChrome {
    @Test
    public void addBlockerExtention() {

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addExtensions(new File("C:\\Users\\LENOVO T480\\Downloads\\AdBlocker1.crx"));
        WebDriver driver=new ChromeDriver(chromeOptions);
        driver.get("https://www.youtube.com/");
    }
}
