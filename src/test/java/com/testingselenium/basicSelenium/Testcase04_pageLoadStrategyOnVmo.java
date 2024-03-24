package com.testingselenium.basicSelenium;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;
public class Testcase04_pageLoadStrategyOnVmo {

    @Test
    public void pageLoadOnVmoApp(){

        ChromeOptions chromeOptions=new ChromeOptions();
        //chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        //chromeOptions.setPageLoadStrategy(PageLoadStrategy.EAGER);
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.NONE);

        WebDriver driver=new ChromeDriver(chromeOptions);
        driver.get("https://app.vwo.com/#/login");

        String title=driver.getTitle();
        System.out.println(title);

        driver.quit();
    }
}
