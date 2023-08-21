package com.demoqa;

import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;

public class DemoqaTests extends TestBase{
    @Test
    void successfulSearchTest() {
        open("/automation-practice-form");
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");
        $("#firstName").setValue("Missis Elena");
        $("#lastName").setValue("Ford");
        $("#userEmail").setValue("vv@aa.com");
        $(byText("Female")).click();
        $("#userNumber").setValue("7777777777");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").click();
        $(byText("July")).click();
        $(".react-datepicker__year-select").click();
        $(byText("1993")).click();
        $(".react-datepicker__day--014").click();
        $("#subjectsInput").setValue("History");
        $("#subjectsInput").pressEnter();
        $(byText("Sports")).click();
        $("#uploadPicture").uploadFile(new File("src/test/resources/7.jpeg"));
        $("#currentAddress").setValue("Str-90");
        $("#state").click();
        $(byText("NCR")).click();
        $("#city").click();
        $(byText("Delhi")).click();
        $("#submit").click();
        $(".table").shouldHave(
                text("Missis Elena Ford"),
                text("vv@aa.com"),
                text("Female"),
                text("7777777777"),
                text("14 July,1993"),
                text("History"),
                text("Sports"),
                text("7.jpeg"),
                text("Str-90"),
                text("NCR Delhi"));


    }
}

