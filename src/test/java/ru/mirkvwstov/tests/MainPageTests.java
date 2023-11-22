package ru.mirkvwstov.tests;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.*;
import ru.mirkvwstov.components.SearchResultsTableComponent;
import ru.mirkvwstov.pages.PageObject;
import ru.mirkvwstov.tests.TestBase;
import ru.mirkvwstov.utils.TestData;

import static com.codeborne.selenide.Selenide.executeJavaScript;
import static io.qameta.allure.Allure.step;

public class MainPageTests extends TestBase {

    PageObject pageObject = new PageObject();
    TestData testData = new TestData();
    SearchResultsTableComponent searchResults = new SearchResultsTableComponent();

    @Test
    @Tags({
            @Tag("smoke"),
            @Tag("main")
    })
    @DisplayName("Checking the presence of the minimum required elements on the main page")
    void testOfRequiredElementsOnTheMainPage() {
        step("Checking the page title", () -> {
            pageObject.checkHeaderOnMainPage(testData.headerMainPage);
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
            @Tag("smoke"),
            @Tag("main"),
            @Tag("filters")
    })
    @DisplayName("Checking the use of filters on the main page")
    void testFiltersOnTheMainPage() {
        step("Choose a scary quest type", () -> {
            pageObject.selectValueFromTheDropdownList(testData.scaryQuest);
        });
        step("Choose a scary quest type", () -> {
            pageObject.selectValueFromTheDropdownList(testData.numberOfPlayers);
        });
        step("Select quest data", () -> {
            pageObject.selectQuestData(testData.questDateSelectionMenu);
        });
        step("Select quest time", () -> {
            pageObject.selectValueFromTheDropdownList(testData.questTime);
        });
        step("Perform a search using the specified filters", () -> {
            pageObject.selectValueFromTheDropdownList(testData.questSearchButton);
        });

        step("Checking the display of the form with selected filters", () -> {
            pageObject.resultsTableOpened();
        });
        step("Checking the display of the form with selected filters", () -> {
            pageObject.resultsTableOpened();
        });
        step("Checking if the selected filters are in the search results", () -> {
            searchResults.searchResultsForm(testData.scaryQuest)
                    .searchResultsForm(testData.questTime)
                    .searchResultsForm(testData.numberOfPlayers);
        });

        step("Checking whether the type of quest selected in the filter is in the search results", () -> {
            pageObject.questTypeCheck(testData.fieldWithQuestType);
        });
    }

    @BeforeEach
    void beforeEach() {
        Selenide.open("/");
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");
    }


}
