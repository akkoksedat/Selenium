package tests;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.WebTablesPage;

import static com.codeborne.selenide.Selenide.open;
import static org.assertj.core.api.Assertions.assertThat;

public class AddRecordTest {

    private WebTablesPage webTablesPage;

    @BeforeClass
    public void setUp() {
        Configuration.browserSize = String.valueOf(true);
        webTablesPage = new WebTablesPage();
    }

    @Test
    public void testAddRecord() {
        open("https://demoqa.com/webtables");
        webTablesPage.addButton.click();
        webTablesPage.firstNameInput.setValue("John");
        webTablesPage.lastNameInput.setValue("Doe");
        webTablesPage.submitButton.click();
        webTablesPage.editButton.click();
        webTablesPage.firstNameInput.setValue("Jane");
        webTablesPage.submitButton.click();
        assertThat(webTablesPage.editButton.getText()).isEqualTo("Jane");
    }
}
