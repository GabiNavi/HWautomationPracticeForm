import org.junit.jupiter.api.Test;

import java.lang.module.Configuration;

public class HWautoPracticeFormT {
    @beforeAll
    static void beforeAll() {
        Configuration.browser = "edge";
        Configuration.baseUrl = "https://demoqa.com/";

    }
    @Test
    void FillFormTest() {

    }
}
