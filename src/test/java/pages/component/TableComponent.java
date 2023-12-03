package pages.component;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class TableComponent {
    private SelenideElement tableElement = $(".table-responsive");
    public TableComponent checkResult(String key, String value) {
        tableElement.$(byText(key)).parent()
                .shouldHave(text(value));

        return this;
    }
}
