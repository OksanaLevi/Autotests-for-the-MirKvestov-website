package ru.mirkvwstov.tests;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.*;
import ru.mirkvwstov.pages.PageObject;
import ru.mirkvwstov.utils.TestData;

import static com.codeborne.selenide.Selenide.executeJavaScript;
import static io.qameta.allure.Allure.step;

public class QuestComparisonTests extends TestBase {

        PageObject pageObject = new PageObject();
        TestData testData = new TestData();

    @Test
    @Tags({
            @Tag("smoke"),
            @Tag("comparison")
    })
    @DisplayName("Проверка функции сравнения 2 квестов")
    void compareTwoQuestsTest() {
        step("Добавить первы квест для сравнения", () -> {
            pageObject.addQuestToComparisonPage();
        });

}
    @BeforeEach
    void beforeEach() {
        Selenide.open("/");
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");
    }
}
