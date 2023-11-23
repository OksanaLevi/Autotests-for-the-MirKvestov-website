package ru.mirkvwstov.tests.pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.*;
import ru.mirkvwstov.components.SearchResultsTableComponent;
import ru.mirkvwstov.pages.PageObject;
import ru.mirkvwstov.tests.TestBase;
import ru.mirkvwstov.utils.TestData;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.executeJavaScript;
import static io.qameta.allure.Allure.step;

public class MainPageTests extends TestBase {

    PageObject pageObject = new PageObject();
    TestData testData = new TestData();
    SearchResultsTableComponent searchResults = new SearchResultsTableComponent();

    SelenideElement resultsSearch = $("#search-form");

    @Test
    @Tags({
            @Tag("smoke"),
            @Tag("main")
    })
    @DisplayName("Проверка наличия обязательных блоков на главной странице")
    void testOfRequiredElementsOnTheMainPage() {
        step("Проверяем заголовок страницы", () -> {
            pageObject.checkHeaderOnMainPage(testData.headerMainPage);
        });
        step("Проверяем наличие фильтров для поиска квеста", () -> {
            pageObject.checkingForFilterPresence(testData.questTypeFilter);
            pageObject.checkingForFilterPresence(testData.playerCountFilter);
            pageObject.checkingForFilterPresence(testData.questDateSelectionMenu);
            pageObject.checkingForFilterPresence(testData.questTimeMenu);
            pageObject.findQuestUsingSpecifiedFilters(testData.questSearchButton);
        });
        step("Проверка наличия квестов и переход в один из них", () -> {
            pageObject.goToQuestPage();
            pageObject.checkHeaderOnPageQuest(testData.eventTypeOnQuestPage);
            pageObject.checkingAvailabilityOfPriceTable(testData.nameOfPriceTable);
        });
    }

    @Test
    @Tags({
            @Tag("smoke"),
            @Tag("main"),
            @Tag("filters")
    })
    @DisplayName("Проверяем работу фильтров на главной странице")
    void testFiltersOnTheMainPage() {
        step("Выбираем тип квеста - страшный", () -> {
            pageObject.selectValueFromTheDropdownList(testData.scaryQuest);
        });
        step("Выбираем количество участников квеста", () -> {
            pageObject.selectValueFromTheDropdownList(testData.numberOfPlayers);
        });
        step("Выбираем дату квеста", () -> {
            pageObject.selectQuestData(testData.questDateSelectionMenu);
        });
        step("Выбираем время квеста", () -> {
            pageObject.selectValueFromTheDropdownList(testData.questTime);
        });
        step("Выполняем поиск квестов по выбранным фильтрам", () -> {
            pageObject.selectValueFromTheDropdownList(testData.questSearchButton);
        });

        step("Проверяем, что открылась страница с результатми поиска", () -> {
            pageObject.resultsTableOpened(resultsSearch, testData.scaryQuestTableResults);
        });
        step("Проверяем наличие выбранных ранее фильтров в результатах поиска", () -> {
            searchResults.searchResultsForm(testData.scaryQuest)
                    .searchResultsForm(testData.questTime)
                    .searchResultsForm(testData.numberOfPlayers);
        });

        step("Переход в квест из списка с результатами и проверка его типа на соответствие с выбранным", () -> {
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
