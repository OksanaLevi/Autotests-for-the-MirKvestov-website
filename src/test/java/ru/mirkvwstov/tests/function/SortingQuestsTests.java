package ru.mirkvwstov.tests.function;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;
import ru.mirkvwstov.pages.PageObject;
import ru.mirkvwstov.tests.TestBase;
import ru.mirkvwstov.utils.TestData;

import static com.codeborne.selenide.Selenide.executeJavaScript;
import static io.qameta.allure.Allure.step;

@Epic("Главная страница сайта Мир Квестов")
@Story("Сортировка квестов")
@Owner("Левинская Оксана")
public class SortingQuestsTests extends TestBase {

    PageObject pageObject = new PageObject();
    TestData testData = new TestData();

    @Test
    @Tags({
            @Tag("smoke"),
            @Tag("main"),
            @Tag("sorting")
    })
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Проверка сортировки квестов по популярности")
    void sortingQuestsByPopularityTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Сортируем квесты по популярности", () -> {
            pageObject.selectSorting(testData.byPopularity);
        });
        step("Проверяем популярность квеста из списка с результатами сортировки", () -> {
            pageObject.checkThePopularityOfTheQuest();
        });
    }

    @Test
    @Tags({
            @Tag("smoke"),
            @Tag("main"),
            @Tag("sorting")
    })
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Проверка сортировки квестов по рейтингу")
    void sortingQuestsByRatingTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Сортируем квесты по рейтингу", () -> {
            pageObject.selectSorting(testData.byRating);
        });
        step("Проверяем рейтинг квеста из списка с результатами сортировки", () -> {
            pageObject.checkTheRatingOfTheQuest(testData.questAssessment);
        });
    }

    @BeforeEach
    void beforeEach() {
        Selenide.open("/");
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");
    }
}
