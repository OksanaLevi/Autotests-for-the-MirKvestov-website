package ru.mirkvwstov.tests.main;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.*;
import org.junit.jupiter.api.*;
import ru.mirkvwstov.pages.MainPage;
import ru.mirkvwstov.pages.components.SearchResultsTableComponent;
import ru.mirkvwstov.tests.TestBase;
import ru.mirkvwstov.utils.TestData;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.executeJavaScript;
import static io.qameta.allure.Allure.step;

@Epic("Главная страница сайта Мир Квестов")
@Story("Оформление блоков на главной странице")
@Owner("Левинская Оксана")
public class MainPageTests extends TestBase {

    MainPage mainPage = new MainPage();
    TestData testData = new TestData();
    SearchResultsTableComponent searchResults = new SearchResultsTableComponent();

    SelenideElement resultsSearch = $("#search-form");

    @Test
    @Tags({
            @Tag("smoke"),
            @Tag("main")
    })
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Проверка наличия обязательных блоков на главной странице")
    void testOfRequiredElementsOnTheMainPage() {

        step("Проверяем заголовок страницы", () -> {
            mainPage.checkHeaderOnMainPage(testData.headerMainPage);
        });
        step("Проверяем наличие фильтров для поиска квеста", () -> {
            mainPage.checkingForFilterPresence(testData.questTypeFilter);
            mainPage.checkingForFilterPresence(testData.playerCountFilter);
            mainPage.checkingForFilterPresence(testData.questDateSelectionMenu);
            mainPage.checkingForFilterPresence(testData.questTimeMenu);
            mainPage.findQuestUsingSpecifiedFilters(testData.questSearchButton);
        });
        step("Проверка наличия квестов и переход в один из них", () -> {
            mainPage.goToQuestPage(testData.questNumberOne);
            mainPage.checkHeaderOnPageQuest(testData.eventTypeOnQuestPageQuest);
            mainPage.checkingAvailabilityOfPriceTable(testData.nameOfPriceTable);
        });
    }

    @Test
    @Tags({
            @Tag("smoke"),
            @Tag("main"),
            @Tag("filters")
    })
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Проверяем работу фильтров на главной странице")
    void testFiltersOnTheMainPage() {

        step("Выбираем тип квеста - страшный", () -> {
            mainPage.selectValueFromTheDropdownList(testData.scaryQuest);
        });
        step("Выбираем количество участников квеста", () -> {
            mainPage.selectValueFromTheDropdownList(testData.numberOfPlayers);
        });
        step("Выбираем дату квеста", () -> {
            mainPage.selectQuestData(testData.questDateSelectionMenu);
        });
        step("Выбираем время квеста", () -> {
            mainPage.selectValueFromTheDropdownList(testData.questTime);
        });
        step("Выполняем поиск квестов по выбранным фильтрам", () -> {
            mainPage.selectValueFromTheDropdownList(testData.questSearchButton);
        });

        step("Проверяем, что открылась страница с результатми поиска", () -> {
            mainPage.resultsTableOpened(resultsSearch, testData.scaryQuestTableResults);
        });
        step("Проверяем наличие выбранных ранее фильтров в результатах поиска", () -> {
            searchResults.searchResultsForm(testData.scaryQuest)
                    .searchResultsForm(testData.questTime)
                    .searchResultsForm(testData.numberOfPlayers);
        });

        step("Переход в квест из списка с результатами и проверка его типа на соответствие с выбранным", () -> {
            mainPage.questTypeCheck(testData.fieldWithQuestType);
        });
    }

    @BeforeEach
    void beforeEach() {
        Selenide.open("");
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");
    }
}
