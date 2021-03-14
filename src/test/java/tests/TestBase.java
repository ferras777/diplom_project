package tests;

import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.open;
import static config.ConfigHelper.getWebUrl;
import static helpers.AttachmentsHelper.*;
import static helpers.DriverHelper.configureDriver;
import static helpers.DriverHelper.getConsoleLogs;

public class TestBase {

    @BeforeAll
    public static void beforeAll() {
        configureDriver();
    }

    @BeforeEach
    public void setUp() {
        open(getWebUrl());
    }

    @AfterEach
    public void addAttachments() {
        attachScreenshot("Last screenshot");
        attachPageSource();
        attachAsText("Browser console logs", getConsoleLogs());

        WebDriverRunner.closeWebDriver();
    }
}
