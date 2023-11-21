package ru.mirkvwstov.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import ru.mirkvwstov.pages.PageObject;
import ru.mirkvwstov.utils.TestData;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;

public class MainPageTests extends TestBase {

    PageObject pageObject = new PageObject();
    TestData testData = new TestData();

    @Test
    @Tags({
            @Tag ("positive"),
            @Tag ("main")
    })
    @DisplayName("Checking the presence of the minimum required elements on the main page")
    void testOfRequiredElementsOnTheMainPage() {
        step("Open main page", () -> {
            pageObject.openPage();
        });
        step("Checking the page title", () -> {
            pageObject.checkHeader(testData.heaherMainPage);
        });
        step("Checking the presence of filters for searching quests", () -> {
            pageObject.checkingForFilterPresence(testData.questTypeFilter);
            pageObject.checkingForFilterPresence(testData.playerCountFilter);
            pageObject.checkingForFilterPresence(testData.questDateSelectionMenu);
            pageObject.checkingForFilterPresence(testData.questTimeMenu);
            pageObject.findQuestUsingSpecifiedFilters(testData.questSearchButton);
        });
        step("Checking for the presence of popular quests and successful transition to one of them", () -> {

            $(".quests-popular .quest-tile-1__title").$(byText("Проклятие")).click();
            $("h1").shouldHave(text("Проклятие"));
            $(".timetable").shouldHave(text("Стоимость игры:"));
        });

    }
}
