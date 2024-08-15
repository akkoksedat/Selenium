package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;


public class WebTablesPage {
    public SelenideElement addButton = $("#addNewRecordButton"); // "ADD" düğmesi
    public SelenideElement firstNameInput = $("#firstName"); // Ad alanı
    public SelenideElement lastNameInput = $("#lastName"); // Soyad alanı
    public SelenideElement submitButton = $("#submit"); // Kaydet düğmesi
    public SelenideElement editButton = $(".mr-2"); // Düzenle düğmesi

    public WebTablesPage open() {
        return page(this);
    }
}
