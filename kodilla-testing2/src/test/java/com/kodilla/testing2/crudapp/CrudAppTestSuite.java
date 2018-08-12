package com.kodilla.testing2.crudapp;

import com.kodilla.testing2.config.WebDriverConfig;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.Random;
import java.util.stream.Collectors;

public class CrudAppTestSuite {

    private static final String BASE_URL = "https://gorczynski-mike.github.io";
    private WebDriver driver;
    private Random generator;

    @Before
    public void initTests() {
        driver = WebDriverConfig.getDriver(WebDriverConfig.CHROME);
        driver.get(BASE_URL);
        generator = new Random();
    }

    @Test
    public void shouldCreateTrelloCard() throws InterruptedException {
        String taskName = createCrudAppTestTask();
        sendTaskToTrello(taskName);
        deleteCrudAppTestTask(taskName);
        Assert.assertTrue(checkTaskExistsInTrello(taskName));
    }

    private String createCrudAppTestTask() throws InterruptedException {
        final String XPATH_TASK_NAME = "//form[contains(@action, \"createTask\")]/fieldset[1]/input";
        final String XPATH_TASK_CONTENT = "//form[contains(@action, \"createTask\")]/fieldset[2]/textarea";
        final String XPATH_ADD_BUTTON = "//form[contains(@action, \"createTask\")]/fieldset[3]/button";

        String taskName = "Task number: " + generator.nextInt(1000000);
        String taskContent = taskName + " content";

        WebElement name = driver.findElement(By.xpath(XPATH_TASK_NAME));
        name.sendKeys(taskName);

        WebElement content = driver.findElement(By.xpath(XPATH_TASK_CONTENT));
        content.sendKeys(taskContent);

        WebElement addButton = driver.findElement(By.xpath(XPATH_ADD_BUTTON));
        addButton.click();
        Thread.sleep(2000);

        return taskName;
    }

    private void deleteCrudAppTestTask(final String taskName) throws InterruptedException {
        driver.switchTo().alert().accept();

        Thread.sleep(500);

        driver.navigate().refresh();

        Thread.sleep(1000);

        driver.findElements(By.xpath("//form[@class=\"datatable__row\"]")).stream()
                .filter(tableRow ->
                        tableRow.findElement(By.xpath(".//p[@class=\"datatable__field-value\"]")).getText().contains(taskName))
                .forEach(tableRow ->
                    tableRow.findElements(By.xpath(".//button")).stream()
                            .filter(button -> button.getText().contains("Delete"))
                            .forEach(button -> button.click())
                );

        Thread.sleep(500);
    }

    private void sendTaskToTrello(String taskName) throws InterruptedException {
        driver.navigate().refresh();

        while(!driver.findElement(By.xpath("//select[1]")).isDisplayed());

        driver.findElements(By.xpath("//form[@class=\"datatable__row\"]")).stream()
        .filter(anyForm ->
                anyForm.findElement(By.xpath(".//p[@class=\"datatable__field-value\"]"))
                    .getText().equals(taskName))
        .forEach(theForm -> {
                    WebElement selectElement = theForm.findElement(By.xpath(".//select[1]"));
                    Select select = new Select(selectElement);
                    select.selectByIndex(1);

                    WebElement buttonCreateCard =
                            theForm.findElement(By.xpath(".//button[contains(@class, \"card-creation\")]"));
                    buttonCreateCard.click();
                });
        Thread.sleep(4000);
    }

    private boolean checkTaskExistsInTrello(String taskName) throws InterruptedException {
        final String TRELLO_URL = "https://trello.com/login";
        boolean result = false;
        WebDriver driverTrello = WebDriverConfig.getDriver(WebDriverConfig.CHROME);
        driverTrello.get(TRELLO_URL);

        driverTrello.findElement(By.id("user")).sendKeys("michalgorczynski89@gmail.com");
        driverTrello.findElement(By.id("password")).sendKeys("KodillaPassword");
        driverTrello.findElement(By.id("login")).submit();

        Thread.sleep(2000);

        driverTrello.findElement(By.xpath("//a[@href=\"/michalgorczynski/boards\"]")).click();

        Thread.sleep(2000);

        driverTrello.findElements(By.xpath("//a[@class=\"board-tile\"]")).stream()
            .filter(aHref -> aHref.findElements(By.xpath(".//div[@title=\"Kodilla Application\"]")).size() > 0)
            .forEach(aHref -> aHref.click());

        Thread.sleep(2000);

        result = driverTrello.findElements(By.xpath("//span[@class=\"list-card-title js-card-name\"]")).stream()
            .filter(theSpan -> theSpan.getText().contains(taskName))
            .collect(Collectors.toList())
            .size() > 0;
        driverTrello.close();
        return result;
    }

    @After
    public void cleanUpAfterTests() {
        driver.close();
    }

}
