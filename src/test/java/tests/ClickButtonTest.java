package tests;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.ElementsPage;

import static com.codeborne.selenide.Selenide.open;
import static org.assertj.core.api.Assertions.assertThat;

public class ClickButtonTest {

    private ElementsPage elementsPage;

    @BeforeClass
    public void setUp() {
        Configuration.browserSize = String.valueOf(true);
        elementsPage = new ElementsPage();
    }

    @Test
    public void testClickButton() {
        open("https://demoqa.com/elements");
        elementsPage.buttonsOption.click();
        elementsPage.clickMeButton.click();
        assertThat(elementsPage.clickMeButton.getText()).isEqualTo("You have done a dynamic click");
    }
}
