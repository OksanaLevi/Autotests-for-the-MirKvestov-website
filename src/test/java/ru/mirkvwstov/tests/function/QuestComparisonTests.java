package ru.mirkvwstov.tests.function;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.*;
import ru.mirkvwstov.pages.PageObject;
import ru.mirkvwstov.tests.TestBase;
import ru.mirkvwstov.utils.TestData;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.executeJavaScript;
import static io.qameta.allure.Allure.step;

public class QuestComparisonTests extends TestBase {

    PageObject pageObject = new PageObject();
    TestData testData = new TestData();

    SelenideElement resultsTable = $(".owl-wrapper-outer");

    @Test
    @Tags({
            @Tag("smoke"),
            @Tag("comparison")
    })
    @DisplayName("Проверка функции сравнения 2 квестов")
    void compareTwoQuestsTest() {
        step("Добавить первый квест для сравнения", () -> {
            pageObject.addQuestToComparisonPage(testData.questNumberOne);
        });
        step("Добавить второй квест для сравнения", () -> {
            pageObject.addQuestToComparisonPage(testData.questNumberTwo);
        });
        step("Перейти на страницу для сравнения квестов", () -> {
            pageObject.openComparisonPage(testData.pageCompare);
        });
        step("Проверим, что таблица сравнения открылась ", () -> {
            pageObject.resultsTableOpened(resultsTable, testData.requiredWordOnComparisonPage);
        });
        step("Проверим, что в сравнении 2 квеста ", () -> {
            pageObject.checkThatTwoQuestsInTheComparisonTable();
        });

    }

    @BeforeEach
    void beforeEach() {
        Selenide.open("/");
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");
    }
}
