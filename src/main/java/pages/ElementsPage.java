package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class ElementsPage {
    public SelenideElement buttonsOption = $("#item-4"); // "Buttons" seçeneği
    public SelenideElement clickMeButton = $("#Dy7CA"); // "Click Me" düğmesi

    public ElementsPage open() {
        return page(this);
    }
}
