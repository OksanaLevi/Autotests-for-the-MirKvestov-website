package ru.mirkvwstov.tests.function;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import ru.mirkvwstov.pages.MainPage;
import ru.mirkvwstov.tests.TestBase;
import ru.mirkvwstov.utils.TestData;

import static io.qameta.allure.Allure.step;

@Epic("Главная страница сайта Мир Квестов")
@Story("Сортировка квестов")
@Owner("Левинская Оксана")
public class SortingQuestsTests extends TestBase {

    MainPage mainPage = new MainPage();
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
        step("Открыть страницу", () -> {
            mainPage.openPage();
        });
        step("Сортируем квесты по популярности", () -> {
            mainPage.selectSorting(testData.byPopularity);
        });
        step("Проверяем популярность квеста из списка с результатами сортировки", () -> {
            mainPage.checkThePopularityOfTheQuest();
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

        step("Открыть страницу", () -> {
            mainPage.openPage();
        });
        step("Сортируем квесты по рейтингу", () -> {
            mainPage.selectSorting(testData.byRating);
        });
        step("Проверяем рейтинг квеста из списка с результатами сортировки", () -> {
            mainPage.checkTheRatingOfTheQuest(testData.questAssessment);
        });
    }
}
