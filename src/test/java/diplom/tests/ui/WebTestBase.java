package diplom.tests.ui;

import io.qameta.allure.junit5.AllureJunit5;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.extension.ExtendWith;

import static com.codeborne.selenide.WebDriverRunner.closeWebDriver;
import static diplom.config.WebConfigHelper.getWebBrowser;
import static diplom.config.WebConfigHelper.isVideoOn;
import static diplom.helpers.AttachmentsHelper.*;
import static diplom.helpers.DriverHelper.*;

@ExtendWith(AllureJunit5.class)
public class WebTestBase {

    @BeforeAll
    public static void beforeAll() {
        configureDriver();
    }

    @AfterEach
    public void addAttachments() {
        attachScreenshot("Last screenshot");
        attachPageSource();
        if (getWebBrowser().equals("chrome")) {
            attachAsText("Browser console logs", getConsoleLogs());
        }
        if (isVideoOn()) {
            attachVideo(getSessionId());
        }
        closeWebDriver();
    }
}
