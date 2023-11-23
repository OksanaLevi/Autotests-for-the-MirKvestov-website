package ru.mirkvwstov.tests;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.*;
import ru.mirkvwstov.pages.PageObject;
import ru.mirkvwstov.utils.TestData;

import static com.codeborne.selenide.Selenide.executeJavaScript;
import static io.qameta.allure.Allure.step;

public class SortingQuestsTests extends TestBase {

    PageObject pageObject = new PageObject();
    TestData testData = new TestData();

    @Test
    @Tags({
            @Tag("smoke"),
            @Tag("main"),
            @Tag("sorting")
    })
    @DisplayName("Checking the sorting of quests by popularity")
    void sortingQuestsByPopularity() {
        step("Sort quests by popularity", () -> {
            pageObject.selectSorting(testData.byPopularity);
        });
        step("Check the popularity of the first quest in the list with results", () -> {
            pageObject.checkThePopularityOfTheQuest();
        });
    }

    @Test
    @Tags({
            @Tag("smoke"),
            @Tag("main"),
            @Tag("sorting")
    })
    @DisplayName("Checking the sorting of quests by rating")
    void sortingQuestsByRating() {
        step("Sort quests by rating", () -> {
            pageObject.selectSorting(testData.byRating);
        });
        step("Check the rating of the first quest in the list with results", () -> {
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
