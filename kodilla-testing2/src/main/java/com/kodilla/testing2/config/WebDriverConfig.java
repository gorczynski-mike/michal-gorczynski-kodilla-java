package com.kodilla.testing2.config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverConfig {

    public static final String FIREFOX = "FIREFOX_DRIVER";
    public static final String CHROME = "CHROME_DRIVER";

    public static WebDriver getDriver(final String driver) {
        System.setProperty("webdriver.gecko.driver", "d:\\Selenium_drivers\\Firefox\\geckodriver.exe");
        System.setProperty("webdriver.chrome.driver", "d:\\Selenium_drivers\\Chrome\\chromedriver.exe");

        if(driver.equals("FIREFOX_DRIVER")) {
            return new FirefoxDriver();
        } else if (driver.equals("CHROME_DRIVER")) {
            return new ChromeDriver();
        } else {
            return null;
        }
    }

}
