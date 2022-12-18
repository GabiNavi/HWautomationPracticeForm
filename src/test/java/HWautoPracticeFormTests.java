import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
//import com.codeborne.selenide.commands.ShouldBe;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
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

        String firstName = "Ivan";
        String lastName = "Ivanov";
        String Email = "ivan@ivanov.com";
//        String Mobile = "1234567890";
//        String Subj1 = "chem";
//        String Subj2 = "math";
//        String cAddress = "Random st., app. 12";

        open("/automation-practice-form");
        Selenide.executeJavaScript("document.body.style.zoom='100%'");
        Selenide.executeJavaScript("$('#fixedban').remove()");
        Selenide.executeJavaScript("$('footer').remove()");

        $(".main-header").shouldHave(text("Practice Form"));
        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(Email);


    }
}
