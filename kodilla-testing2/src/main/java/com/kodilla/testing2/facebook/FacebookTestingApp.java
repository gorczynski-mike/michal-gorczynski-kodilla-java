package com.kodilla.testing2.facebook;

import com.kodilla.testing2.config.WebDriverConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class FacebookTestingApp {

    public static final String FACEBOOK_URL = "https://www.facebook.com/";
    public static final String FACEBOOK_REGISTRATION_FIRSTNAME = "firstname";
    public static final String FACEBOOK_REGISTRATION_LASTNAME = "lastname";
    public static final String FACEBOOK_REGISTRATION_EMAIL = "reg_email__";
    public static final String FACEBOOK_REGISTRATION_EMAILCONFIRMATION = "reg_email_confirmation__";
    public static final String FACEBOOK_REGISTRATION_PASSWORD = "reg_passwd__";
    public static final String FACEBOOK_REGISTRATION_BDAY_DAY = "day";
    public static final String FACEBOOK_REGISTRATION_BDAY_MONTH = "month";
    public static final String FACEBOOK_REGISTRATION_BDAY_YEAR = "year";
    public static final String FACEBOOK_REGISTRATION_MALE_RADIO = "u_0_a";


    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverConfig.getDriver(WebDriverConfig.FIREFOX);
        driver.get(FACEBOOK_URL);

        WebElement regFirstname = driver.findElement(By.name(FACEBOOK_REGISTRATION_FIRSTNAME));
        regFirstname.sendKeys("Adam");

        WebElement regLastname = driver.findElement(By.name(FACEBOOK_REGISTRATION_LASTNAME));
        regLastname.sendKeys("Adamski");

        WebElement regEmail = driver.findElement(By.name(FACEBOOK_REGISTRATION_EMAIL));
        regEmail.sendKeys("adam@adamski.com");

        WebElement regPasswd = driver.findElement(By.name(FACEBOOK_REGISTRATION_PASSWORD));
        regPasswd.sendKeys("password");

        WebElement comboDay = driver.findElement(By.id(FACEBOOK_REGISTRATION_BDAY_DAY));
        Select daySelect = new Select(comboDay);
        daySelect.selectByIndex(1);

        WebElement comboMonth = driver.findElement(By.id(FACEBOOK_REGISTRATION_BDAY_MONTH));
        Select monthSelect = new Select(comboMonth);
        monthSelect.selectByIndex(1);

        WebElement comboYear = driver.findElement(By.id(FACEBOOK_REGISTRATION_BDAY_YEAR));
        Select yearSelect = new Select(comboYear);
        yearSelect.selectByValue("1970");

        WebElement maleRadioButton = driver.findElement(By.id(FACEBOOK_REGISTRATION_MALE_RADIO));
        maleRadioButton.click();

        while(!driver.findElement(By.name(FACEBOOK_REGISTRATION_EMAILCONFIRMATION)).isDisplayed()) {
            Thread.sleep(1000);
        }

        WebElement regEmailConfirmation = driver.findElement(By.name(FACEBOOK_REGISTRATION_EMAILCONFIRMATION));
        regEmailConfirmation.sendKeys("adam@adamski.com");
    }

}
