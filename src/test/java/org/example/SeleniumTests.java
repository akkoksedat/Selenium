package org.example;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SeleniumTests {
    private static WebDriver driver;

    @BeforeEach
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "/Users/sedat/Desktop/sedat/Selenium/drivers/chromedriver");
        driver = new ChromeDriver();
    }
        @Test
    public void testClickButton() {
        driver.get("https://demoqa.com/elements");
        WebElement buttonsMenu = driver.findElement(By.cssSelector("li#item-4"));
        buttonsMenu.click();

       WebElement click = driver.findElement(By.cssSelector("#Orhsl"));
       click.click();

        WebElement message = driver.findElement(By.id("dynamicClickMessage"));
        assertEquals("You have done a dynamic click", message.getText(), "Mesaj doğrulandı.");
    }

    @Test
    public void testAddRecord() {
        driver.get("https://demoqa.com/webtables");

        WebElement addButton = driver.findElement(By.id("addNewRecordButton"));
        addButton.click();

        WebElement firstNameInput = driver.findElement(By.cssSelector("input#firstName"));
        firstNameInput.sendKeys("sedat");

        WebElement lastNameInput = driver.findElement(By.cssSelector("input#lastName"));
        lastNameInput.sendKeys("akkok");

        WebElement emailInput = driver.findElement(By.cssSelector("input#userEmail"));
        emailInput.sendKeys("sedat@gmail.com");

        WebElement ageInput = driver.findElement(By.cssSelector("input#age"));
        ageInput.sendKeys("30");

        WebElement salaryInput = driver.findElement(By.cssSelector("input#salary"));
        salaryInput.sendKeys("10000");

        WebElement departmentInput = driver.findElement(By.cssSelector("input#department"));
        departmentInput.sendKeys("qa engineer");

        WebElement submitButton = driver.findElement(By.id("submit"));
        submitButton.click();  // Formu göndermek için bu satırı ekleyin
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
