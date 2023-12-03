package test;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;

public class BaseTest {
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x800";
        Configuration.baseUrl = "https://demoqa.com";

    }
}
