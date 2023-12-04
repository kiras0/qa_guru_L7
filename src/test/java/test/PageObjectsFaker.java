package test;


import org.junit.jupiter.api.Test;
import pages.FormTestPage;
import pages.component.TableComponent;
import utils.RandomUtils;


public class PageObjectsFaker extends BaseTest {

    FormTestPage formTestPage = new FormTestPage();
    TableComponent tableComponent = new TableComponent();
    RandomUtils randomUtils = new RandomUtils();
    @Test
    void fillFormTest() {

        formTestPage.openPage()
                .closeBanner()
                .setFirstName(randomUtils.firstName)
                .setLastName(randomUtils.lastName)
                .setUserEmail(randomUtils.userEmail)
                .setGender(randomUtils.gender)
                .setUserNumber(randomUtils.number)
                .setDateOfBirth(randomUtils.monthOfBirth, randomUtils.yearOfBirth, randomUtils.dayOfBirth)
                .setSubjects(randomUtils.subjects)
                .setHobbies(randomUtils.hobbies)
                .setPicture()
                .setAddress(randomUtils.userAddress)
                .setState(randomUtils.state)
                .setCity(randomUtils.city)
                .pressSubmit();




        tableComponent.checkResult("Student Name", randomUtils.firstName + " " + randomUtils.lastName)
                .checkResult("Student Email", randomUtils.userEmail)
                .checkResult("Gender", randomUtils.gender)
                .checkResult("Mobile", randomUtils.number)
                .checkResult("Date of Birth", randomUtils.dayOfBirth + " " + randomUtils.monthOfBirth + "," + randomUtils.yearOfBirth)
                .checkResult("Subjects", randomUtils.subjects)
                .checkResult("Hobbies", randomUtils.hobbies)
                .checkResult("Picture", "image.png")
                .checkResult("Address", randomUtils.userAddress)
                .checkResult("State and City", randomUtils.state + " " + randomUtils.city);
    }

    @Test
    void requiredFieldFillFormTest() {
        formTestPage.openPage()
                .closeBanner()
                .setFirstName(randomUtils.firstName)
                .setLastName(randomUtils.lastName)
                .setGender(randomUtils.gender)
                .setUserNumber(randomUtils.number)
                .setDateOfBirth(randomUtils.monthOfBirth, randomUtils.yearOfBirth, randomUtils.dayOfBirth)
                .pressSubmit();
        tableComponent.checkResult("Student Name", randomUtils.firstName + " " + randomUtils.lastName)
                .checkResult("Gender", randomUtils.gender)
                .checkResult("Mobile", randomUtils.number)
                .checkResult("Date of Birth", randomUtils.dayOfBirth + " " + randomUtils.monthOfBirth + "," + randomUtils.yearOfBirth);
    }
    @Test
    void unfilledFillFormTest() {
        formTestPage.openPage()
                .closeBanner()
                .setFirstName(randomUtils.firstName)
                .setUserEmail(randomUtils.userEmail)
                .setGender(randomUtils.gender)
                .setUserNumber(randomUtils.number)
                .pressSubmit();
        tableComponent.checkResultElement("Practice Form");
    }

}


