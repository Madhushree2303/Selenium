package com.testingselenium.webElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Testcase11_Textbox {

    WebDriver driver;

    @Test
    public void textbox(){

        driver=new ChromeDriver();
        driver.get("https://www.leafground.com/input.xhtml;jsessionid=node01mav3kb6gl8bj1fikuw3icnenu480526.node0");

        WebElement text_box=driver.findElement(By.xpath("//input[@id=\"j_idt88:name\"]"));
        text_box.sendKeys("Babu Manickam");

        WebElement appendCitytext_box=driver.findElement(By.xpath("//input[@id=\"j_idt88:j_idt91\"]"));
        appendCitytext_box.sendKeys(" Tirunelveli");

        WebElement disabletext_box=driver.findElement(By.xpath("//input[@id=\"j_idt88:j_idt93\"]"));
        Boolean textbox_disable= disabletext_box.isEnabled();
        if (textbox_disable.equals(false)){
            Assert.assertFalse(textbox_disable);
        }
        driver.quit();

    }
}
