package com.testingselenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import java.util.List;
public class Testcase07_linkTextAndParLink {

    @Test
    public void linkTextAndParLinkText() throws InterruptedException {

        WebDriver driver=new ChromeDriver();
        driver.get("https://app.vwo.com/#/login");
        driver.manage().window().maximize();

        WebElement linktext=driver.findElement(By.linkText("Start a free trial"));
        linktext.click();

        Thread.sleep(2000);
        List<WebElement> newlinks=driver.findElements(By.tagName("a"));

        for (WebElement element:newlinks) {
            System.out.println(element.getText());
        }

        //WebElement parlinktext=driver.findElement(By.partialLinkText("Privacy"));
        //parlinktext.click();

        //driver.close();

    }
}
