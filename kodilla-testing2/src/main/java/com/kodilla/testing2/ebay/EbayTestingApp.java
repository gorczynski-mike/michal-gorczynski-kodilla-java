package com.kodilla.testing2.ebay;

import com.kodilla.testing2.config.WebDriverConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EbayTestingApp {

    public static final String SEARCHFIELD = "gh-ac";
    public static final String EBAYURL = "https://www.ebay.com/";

    public static void main(String[] args) {
        WebDriver driver = WebDriverConfig.getDriver(WebDriverConfig.FIREFOX);
        driver.get(EBAYURL);

        WebElement searchfield = driver.findElement(By.id(SEARCHFIELD));
        searchfield.sendKeys("Laptop");
        searchfield.submit();
    }

}
