package test;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxTest {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
    }
    @Test
    void FillFormTest() {
        open("/text-box");
        $("#userName").setValue("Hello");
        $("#userEmail").setValue("Hello@email.com");
        $("#currentAddress").setValue("Random Address");
        $("#permanentAddress").setValue("Light Address");
        $("#submit").click();

        $("#output #name").shouldHave(text("Hello"));
        $("#output #email").shouldHave(text("Hello@email.com"));
        $("#output #currentAddress").shouldHave(text("Random Address"));
        $("#output #permanentAddress").shouldHave(text("Light Address"));
    }
}


