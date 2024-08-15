package org.example;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class seleniumxpath {
    private static WebDriver driver;

    @BeforeAll
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", "/Users/sedat/Desktop/sedat/Selenium/drivers/chromedriver");
        driver = new ChromeDriver();
    }


    @Test
    public void testClickButton() {

        driver.get("https://demoqa.com/elements");


        WebElement buttonsMenu = driver.findElement(By.xpath("//span[text()='Buttons']"));
        buttonsMenu.click();


        WebElement clickMeButton = driver.findElement(By.xpath("//button[text()='Click Me']"));
        clickMeButton.click();


        WebElement message = driver.findElement(By.xpath("//div[@id='dynamicClickMessage']"));
        assertEquals(message.getText(), "You have done a dynamic click");
    }

    @Test
    public void testAddRecord() {

        driver.get("https://demoqa.com/webtables");


        WebElement addButton = driver.findElement(By.xpath("//button[@id='addNewRecordButton']"));
        addButton.click();


        WebElement firstNameInput = driver.findElement(By.xpath("//input[@id='firstName']"));
        WebElement lastNameInput = driver.findElement(By.xpath("//input[@id='lastName']"));
        WebElement emailInput = driver.findElement(By.xpath("//input[@id='userEmail']"));
        WebElement ageInput = driver.findElement(By.xpath("//input[@id='age']"));
        WebElement salaryInput = driver.findElement(By.xpath("//input[@id='salary']"));
        WebElement departmentInput = driver.findElement(By.xpath("//input[@id='department']"));
        WebElement submitButton = driver.findElement(By.xpath("//button[@id='submit']"));

        firstNameInput.sendKeys("sedat");
        lastNameInput.sendKeys("akkok");
        emailInput.sendKeys("sedatakkok@outlook.com");
        ageInput.sendKeys("30");
        salaryInput.sendKeys("100000");
        departmentInput.sendKeys("qa engineer");
        submitButton.click();


        WebElement editButton = driver.findElement(By.xpath("//span[@title='Edit']"));
        editButton.click();


        firstNameInput.clear();
        firstNameInput.sendKeys("sedat2");
        submitButton.click();


        WebElement editedName = driver.findElement(By.xpath("//div[contains(text(), 'sedat2')]"));
        assertEquals(editedName.getText(), "sedat2");
    }

    @AfterAll
    public static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
