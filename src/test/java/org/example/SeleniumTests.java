package org.example;

import org.junit.BeforeClass;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SeleniumTests {
    private static WebDriver driver;

    @BeforeClass
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", "/Users/sedat/Desktop/sedat/Selenium/drivers/chromedriver");
        driver = new ChromeDriver();
    }

    @AfterEach
    public void tearDown() {

        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void testClickButton() {

        driver.get("https://demoqa.com/elements");
        WebElement buttonsMenu = driver.findElement(By.cssSelector("li#item-4"));
        buttonsMenu.click();

        WebElement clickMeButton = driver.findElement(By.cssSelector("button#button"));
        clickMeButton.click();

        WebElement message = driver.findElement(By.id("dynamicClickMessage"));
        assertEquals("You have done a dynamic click", message.getText(), "Mesaj doğrulandı.");
    }

    @Test
    public void testAddRecord() {

        driver.get("https://demoqa.com/webtables");

        WebElement addButton = driver.findElement(By.id("addNewRecordButton"));
        addButton.click();

        WebElement firstNameInput = driver.findElement(By.cssSelector("input#firstName"));
        firstNameInput.sendKeys("John");

        WebElement lastNameInput = driver.findElement(By.cssSelector("input#lastName"));
        lastNameInput.sendKeys("Doe");

        WebElement emailInput = driver.findElement(By.cssSelector("input#userEmail"));
        emailInput.sendKeys("john.doe@example.com");

        WebElement ageInput = driver.findElement(By.cssSelector("input#age"));
        ageInput.sendKeys("30");

        WebElement salaryInput = driver.findElement(By.cssSelector("input#salary"));
        salaryInput.sendKeys("50000");

        WebElement departmentInput = driver.findElement(By.cssSelector("input#department"));
        departmentInput.sendKeys("Engineering");

        WebElement submitButton = driver.findElement(By.id("submit"));

    }
}