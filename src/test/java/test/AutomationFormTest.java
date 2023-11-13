package test;

import com.codeborne.selenide.Configuration;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;



import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class AutomationFormTest {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x800";
        Configuration.baseUrl = "https://demoqa.com";

    }
    @Test
    void fillFormTest() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));

        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        $("#firstName").setValue("Hello");
        $("#lastName").setValue("World");
        $("#userEmail").setValue("helloworld@email.com");
        $("#genterWrapper").$(byText("Other")).click();
        $("#userNumber").setValue("0011223344");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("December");
        $(".react-datepicker__year-select").selectOption("1990");
        $(".react-datepicker__day--010").click();
        $("#subjectsInput").setValue("English").pressEnter();
        $("#hobbiesWrapper").$(byText("Reading")).click();
        $("#uploadPicture").uploadFromClasspath("image.png");
        $("#currentAddress").setValue("Test Address Placed Here");
        $("#state").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Delhi")).click();
        $("#submit").click();

        $(".table-responsive").shouldHave(
                text("Hello World"),
                text("helloworld@email.com"),
                text("Other"),
                text("0011223344"),
                text("10 December,1990"),
                text("English"),
                text("Reading"),
                text("image.png"),
                text("Test Address Placed Here"),
                text("NCR Delhi"));
    }
}


