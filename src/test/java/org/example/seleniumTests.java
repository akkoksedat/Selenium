package org.example;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class seleniumTests {
    private static WebDriver driver;

    @BeforeAll
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", "/Users/sedat/Desktop/sedat/Selenium/drivers/chromedriver");
        driver = new ChromeDriver();
    }
    @Test
    public void testClickButton() {
        driver.get("https://demoqa.com/elements");


        WebElement buttonsMenu = driver.findElement(By.cssSelector("li#item-4"));
        buttonsMenu.click();


        WebElement clickButton = driver.findElement(By.cssSelector("button#dynamicClickButton"));
        clickButton.click();


        WebElement message = driver.findElement(By.cssSelector("#dynamicClickMessage"));
        assertEquals("You have done a dynamic click", message.getText(), "Mesaj doğrulandı.");
    }

    @Test
    public void testAddRecord() {
        driver.get("https://demoqa.com/webtables");

        WebElement addButton = driver.findElement(By.cssSelector("button#addNewRecordButton"));
        addButton.click();

        WebElement firstNameInput = driver.findElement(By.cssSelector("input#firstName"));
        firstNameInput.sendKeys("sedat");

        WebElement lastNameInput = driver.findElement(By.cssSelector("input#lastName"));
        lastNameInput.sendKeys("akkok");

        WebElement emailInput = driver.findElement(By.cssSelector("input#userEmail"));
        emailInput.sendKeys("sedatakkok@outlook.com");

        WebElement ageInput = driver.findElement(By.cssSelector("input#age"));
        ageInput.sendKeys("30");

        WebElement salaryInput = driver.findElement(By.cssSelector("input#salary"));
        salaryInput.sendKeys("50000");

        WebElement departmentInput = driver.findElement(By.cssSelector("input#department"));
        departmentInput.sendKeys("qa engineer");

        WebElement submitButton = driver.findElement(By.cssSelector("button#submit"));
        submitButton.click();

        WebElement editButton = driver.findElement(By.cssSelector("span[title='Edit']"));
        editButton.click();

        WebElement firstNameEdit = driver.findElement(By.cssSelector("input#firstName"));
        firstNameEdit.clear();
        firstNameEdit.sendKeys("sedat2");

        WebElement lastNameEdit = driver.findElement(By.cssSelector("input#lastName"));
        lastNameEdit.clear();
        lastNameEdit.sendKeys("akkok2");

        WebElement salaryEdit = driver.findElement(By.cssSelector("input#salary"));
        salaryEdit.clear();
        salaryEdit.sendKeys("60000");

        WebElement submitEditButton = driver.findElement(By.cssSelector("button#submit"));
        submitEditButton.click();

        WebElement editedRecord = driver.findElement(By.cssSelector("div.rt-tbody .rt-tr-group:last-child"));
        assertEquals("sedat2", editedRecord.findElement(By.cssSelector("div.rt-td:nth-child(1)")).getText(), "Ad doğrulandı.");
        assertEquals("akkok2", editedRecord.findElement(By.cssSelector("div.rt-td:nth-child(2)")).getText(), "Soyad doğrulandı.");
        assertEquals("60000", editedRecord.findElement(By.cssSelector("div.rt-td:nth-child(4)")).getText(), "Maaş doğrulandı.");
    }

    @AfterAll
    public static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}