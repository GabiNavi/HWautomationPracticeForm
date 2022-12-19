import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class HWautoPracticeFormTests {
    @BeforeAll
    static void beforeAll() {
        Configuration.browser = "chrome";
        Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "1440x900";
        Configuration.baseUrl = "https://demoqa.com";
    }

    @Test
    void FillFormTest() {

        //Выносим основные переменные
        String fName = "Ivan";
        String lName = "Ivanov";
        String Email = "ivan@ivanov.com";
        String Mobile = "1234567890";
        String Sub1 = "chem";
        String Sub2 = "math";
        String cAdd = "Random st., app. 12";

        //Прописываем настройки браузера
        open("/automation-practice-form");
        Selenide.executeJavaScript("document.body.style.zoom='100%'");
        Selenide.executeJavaScript("$('#fixedban').remove()");
        Selenide.executeJavaScript("$('footer').remove()");

        //Подтверждаем, что открыли страницу, и заполняем поля имен и адрес почты
        $(".main-header").shouldHave(text("Practice Form"));
        $("#firstName").setValue(fName);
        $("#lastName").setValue(lName);
        $("#userEmail").setValue(Email);

        //Выбираем пол
        $("#gender-radio-1").parent().click();

        //Указываем телефон
        $("#userNumber").setValue(Mobile);

        //Задаем дату рождения
        $("#dateOfBirthInput").click(); // Выбираем 30 June (5) 1991
        $(".react-datepicker__month-select").selectOption("June");
        $(".react-datepicker__year-select").selectOption("1991");
        $(".react-datepicker__day--030:not(.react-datepicker__day--outside-month)").click();

        //Указываем интересы
        $("#subjectsInput").setValue(Sub1).pressEnter();
        $("#subjectsInput").setValue(Sub2).pressEnter();

        //Скролим до кнопки submit
        $("#submit").scrollIntoView(false);

        //Выбираем хобби
        $("label[for = hobbies-checkbox-1]").click();
        $("label[for = hobbies-checkbox-3]").click();

        //Загружаем файл
        $("#uploadPicture").uploadFromClasspath("img/1.png");

        //Указываем текущий адрес
        $("#currentAddress").setValue(cAdd);

        //Указываем регион и город
        $("#stateCity-wrapper").click();
        $("#react-select-3-option-3").click();
        $("#city").click();
        $("#react-select-4-option-1").click();

        //Отпрвляем все введенные данные
        $("#submit").click();

        //Проверяем результат
        $(".modal-content").shouldBe(visible);
        $(".table-responsive").shouldHave(text(fName), text(lName), text(Email), text(Mobile),
                text(Sub1), text(Sub2), text(cAdd));
    }
}
