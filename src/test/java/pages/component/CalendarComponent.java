package pages.component;

import com.codeborne.selenide.SelenideElement;


import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {
    private SelenideElement
            setMonth = $(".react-datepicker__month-select"),
            setYear =  $(".react-datepicker__year-select");


    public void setDate(String Month, String Year, String Day){
        setMonth.selectOption(Month);
        setYear.selectOption(Year);
        $(".react-datepicker__day.react-datepicker__day--0" + Day + ":not(.react-datepicker__day--outside-month)").click();
    }
}
