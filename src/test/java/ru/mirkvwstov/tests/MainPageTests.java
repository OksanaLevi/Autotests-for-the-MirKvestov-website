package ru.mirkvwstov.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.*;
import ru.mirkvwstov.pages.PageObject;
import ru.mirkvwstov.utils.TestData;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.executeJavaScript;
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
        step("Checking the page title", () -> {
            pageObject.checkHeaderOnMainPage(testData.heaherMainPage);
        });
        step("Checking the presence of filters for searching quests", () -> {
            pageObject.checkingForFilterPresence(testData.questTypeFilter);
            pageObject.checkingForFilterPresence(testData.playerCountFilter);
            pageObject.checkingForFilterPresence(testData.questDateSelectionMenu);
            pageObject.checkingForFilterPresence(testData.questTimeMenu);
            pageObject.findQuestUsingSpecifiedFilters(testData.questSearchButton);
        });
        step("Checking for the presence of popular quests and successful transition to one of them", () -> {
            pageObject.goToQuestPage(testData.titleOnQuestPage);
            pageObject.checkHeaderOnPageQuest(testData.titleOnQuestPage);
            pageObject.checkingAvailabilityOfPriceTable(testData.nameOfPriceTable);
        });

}

    @Test
    @Tags({
            @Tag ("positive"),
            @Tag ("main")
    })
    @DisplayName("Checking the use of filters on the main page")
    void testFiltersOnTheMainPage () {
        step("Choose a scary quest type", (listOfQuestTypes) -> {
            pageObject.selectValueFromTheDropdownList(testData.scaryQuest);
        });
        step("Choose a scary quest type", (listOfNumberOfPlayers) -> {
            pageObject.selectValueFromTheDropdownList(testData.numberOfPlayers);
        });
        step("Select quest time", (listOfNumberOfPlayers) -> {
            pageObject.selectValueFromTheDropdownList(testData.questTime);
        });

    }

    @BeforeEach
    void beforeEach() {
//        Configuration.baseUrl = "https://mir-kvestov.ru/";
        Configuration.pageLoadStrategy = "eager";
        Configuration.browserSize = "1920x1080";
        Selenide.open("https://mir-kvestov.ru/");
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");
    }


}
