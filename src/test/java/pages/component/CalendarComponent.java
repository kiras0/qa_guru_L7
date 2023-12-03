package pages.component;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {
    private SelenideElement
            setMonth = $(".react-datepicker__month-select"),
            setYear =  $(".react-datepicker__year-select"),
            setDay = $(".react-datepicker__month");

    public void setDate(String Month, String Year, String Day){
        setMonth.selectOption(Month);
        setYear.selectOption(Year);
        setDay.$(byText(Day)).click();
    }
}
