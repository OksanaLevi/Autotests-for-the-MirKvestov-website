package ru.mirkvwstov.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
//import com.demoqa.helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class TestBase {

    static {
        ChromeOptions options = new ChromeOptions();
        options.setBinary("/Applications/Google Chrome.app/Contents/MacOS/Google Chrome");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        Configuration.browserCapabilities = capabilities;
    }

    @BeforeAll
    static void beforeAll() {
//        Configuration.baseUrl = "https://mir-kvestov.ru/";
        Configuration.pageLoadStrategy = "eager";
        Configuration.browserSize = "1920x1080";
    }
//    @BeforeEach
//    void addListener() {
//        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
//    }
//
//    @AfterEach
//    void addAttachments() {
////        Attach.screenshotAs("Last screenshot");
////        Attach.pageSource();
////        Attach.browserConsoleLogs();
////        Attach.addVideo();
//
////        closeWebDriver();
//    }
}
