package com.demoqa;

import org.junit.jupiter.api.Test;


import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;

public class DemoqaTests extends TestBase{
    private final String firstName = "Missis Elena",
            lastName = "Ford",
            email = "vv@aa.com",
            gender = "Female",
            number = "7777777777",
            month = "July",
            year = "1993",
            day = "14",
            subjects = "History",
            hobbies = "Sports",
            picture = "7.jpeg",
            address = "Str-90",
            state = "NCR",
            city = "Delhi";






    @Test
    void successfulSearchTest() {
        open("/automation-practice-form");
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");
        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(email);
        $(byText(gender)).click();
        $("#userNumber").setValue(number);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").click();
        $(byText(month)).click();
        $(".react-datepicker__year-select").click();
        $(byText(year)).click();
        $(".react-datepicker__day--0" +day).click();
        $("#subjectsInput").setValue(subjects);
        $("#subjectsInput").pressEnter();
        $(byText(hobbies)).click();
        $("#uploadPicture").uploadFromClasspath(picture);
        $("#currentAddress").setValue(address);
        $("#state").click();
        $(byText(state)).click();
        $("#city").click();
        $(byText(city)).click();
        $("#submit").click();
        $(".table").shouldHave(
                text(firstName + " " + lastName),
                text(email),
                text(gender),
                text(number),
                text(day + " " +  month + "," + year),
                text(subjects),
                text(hobbies),
                text(picture),
                text(address),
                text(state + " " + city));


    }
}

