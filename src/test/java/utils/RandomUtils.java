package utils;

import com.github.javafaker.Faker;

public class RandomUtils {
    static public Faker faker = new Faker();


    public String firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            userEmail = faker.internet().emailAddress(),
            gender = faker.options().option("Male", "Female", "Other"),
            number = faker.phoneNumber().subscriberNumber(10),
            monthOfBirth = faker.options().option("January", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"),
            yearOfBirth = String.valueOf(faker.number().numberBetween(1980, 2000)),
            dayOfBirth = String.format("%02d", faker.number().numberBetween(1,28)),
            subjects = faker.options().option("Math", "English", "Chemistry", "Physics", "Computer Science", "Economics", "Arts",
            "Social Studies", "History", "Civics", "Hindi", "Biology", "Accounting", "Commerce"),
            hobbies = faker.options().option("Sports", "Reading", "Music"),
            picture = "image.png",
            userAddress = faker.address().fullAddress(),
            state = faker.options().option("NCR", "Uttar Pradesh", "Haryana", "Rajasthan"),
            city = randomCity(state);
    private String randomCity(String city) {

        if (city=="NCR")
            return faker.options().option("Delhi", "Gurgaon", "Noida");
        else
        if (city=="Uttar Pradesh")
            return faker.options().option("Agra", "Lucknow", "Merrut");
        else
        if (city=="Haryana")
            return faker.options().option("Karnal", "Panipat");
        else
            return faker.options().option("Jaipur", "Jaiselmer");
    }
}
