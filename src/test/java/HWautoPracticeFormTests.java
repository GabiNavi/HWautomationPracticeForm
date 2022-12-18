import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
//import com.codeborne.selenide.commands.ShouldBe;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
//import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class HWautoPracticeFormTests {
    @BeforeAll
    static void beforeAll() {
        Configuration.browser = "edge";
        Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "1440x900";
        Configuration.baseUrl = "https://demoqa.com";
    }

    @Test
    void FillFormTest() {

        String fName = "Ivan";
        String lName = "Ivanov";
        String Email = "ivan@ivanov.com";
        String Mobile = "1234567890";
        String Sub1 = "chem";
        String Sub2 = "math";
        String cAdd = "Random st., app. 12";

        open("/automation-practice-form");
        Selenide.executeJavaScript("document.body.style.zoom='100%'");
        Selenide.executeJavaScript("$('#fixedban').remove()");
        Selenide.executeJavaScript("$('footer').remove()");

        $(".main-header").shouldHave(text("Practice Form"));
        $("#firstName").setValue(fName);
        $("#lastName").setValue(lName);
        $("#userEmail").setValue(Email);

        $("#gender-radio-1").parent().click();
//        $(byText("Male")).click(); //
//        $("#genterWrapper").$(byText("Male")).click(); //
//        $("label[for = gender-radio-1]").click(); //

        $("#userNumber").setValue(Mobile);

        $("#dateOfBirthInput").click(); // Выбираем 30 June (5) 1991
        $(".react-datepicker__month-select").selectOption("June");
        $(".react-datepicker__year-select").selectOption("1991");
//        $(".react-datepicker__month-select").selectOptionByValue("5");
//        $(".react-datepicker__year-select").selectOption("1991");
        $(".react-datepicker__day--030:not(.react-datepicker__day--outside-month)").click();

        $("#subjectsInput").setValue(Sub1);
        $("#subjectsInput").setValue(Sub2);
// Нужно закрыть окно выбора 'сабчекта' перед тем как отмечать хобби
        $("label[for = hobbies-checkbox-1]").click();
        $("label[for = hobbies-checkbox-3]").click();

        $("#currentAddress").setValue(cAdd);
    }
}
