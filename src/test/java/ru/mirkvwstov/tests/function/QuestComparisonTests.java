package ru.mirkvwstov.tests.function;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import ru.mirkvwstov.pages.ComparisonPage;
import ru.mirkvwstov.pages.MainPage;
import ru.mirkvwstov.tests.TestBase;
import ru.mirkvwstov.utils.TestData;

import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;

@Epic("Главная страница сайта Мир Квестов")
@Story("Сравнение квестов")
@Owner("Левинская Оксана")
public class QuestComparisonTests extends TestBase {


    private final SelenideElement resultsTable = $(".owl-wrapper-outer");
    MainPage mainPage = new MainPage();
    ComparisonPage comparisonPageomparisonPage = new ComparisonPage();
    TestData testData = new TestData();

    @Test
    @Tags({
            @Tag("smoke"),
            @Tag("comparison")
    })
    @Severity(SeverityLevel.MINOR)
    @DisplayName("Проверка функции сравнения 2 квестов")
    void compareTwoQuestsTest() {

        step("Открыть страницу", () -> {
            mainPage.openPage();
        });
        step("Добавить первый квест для сравнения", () -> {
            mainPage.addQuestToComparisonPage(testData.questNumberOne);
        });
        step("Добавить второй квест для сравнения", () -> {
            mainPage.addQuestToComparisonPage(testData.questNumberTwo);
        });
        step("Перейти на страницу для сравнения квестов", () -> {
            mainPage.openComparisonPage(testData.pageCompare);
        });
        step("Проверим, что таблица сравнения открылась ", () -> {
            mainPage.resultsTableOpened(resultsTable, testData.requiredWordOnComparisonPage);
        });
        step("Проверим, что в сравнении 2 квеста ", () -> {
            comparisonPageomparisonPage.checkThatTwoQuestsInTheComparisonTable();
        });
    }
}
