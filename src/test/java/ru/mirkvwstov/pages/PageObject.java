package ru.mirkvwstov.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import dev.failsafe.internal.util.Assert;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PageObject {
    private final SelenideElement
    //на главной странице
            headerMainPage = $("h1"),
            filterQuestType = $("#search-form"),
            questSearchButton = $(".row"),
            firstDateFromTheList = $("#date"),
            sortMenu = $(".sort__select"),
    //сравнение квестов
            numberOfTeams = $(".quest-rating-populi .quest-rating-populi__team-count_number"),
    //на странице квеста
            eventType = $(".game-type"),
            questPrice = $(".timetable"),
            questParameters = $(".masthead"),
            questRating = $(".quest-rating-populi__value"),
    //на странице с результатами поиска
            anyQuestFromTheList = $(".quest-tile-1");

    private final ElementsCollection
            questPage = $$(".quest-tile-1"),
            questCompareBtn = $$(".js-quest-compare-btn"),
            questInTableResults  = $$(".owl-item");


    //проверки для теста testOfRequiredElementsOnTheMainPage
    public PageObject checkHeaderOnMainPage(String value) {
        headerMainPage.shouldHave(text(value));

        return this;
    }
    public PageObject checkingForFilterPresence(String value) {
        filterQuestType.shouldHave(text(value));

        return this;
    }
    public PageObject findQuestUsingSpecifiedFilters(String value) {
        questSearchButton.shouldHave(text(value));

        return this;
    }
    public PageObject goToQuestPage(int value) {
        questPage.get(value).click();

        return this;
    }
    public PageObject checkHeaderOnPageQuest(String quest) {
        eventType.shouldHave(text(quest));

        return this;
    }
    public PageObject checkingAvailabilityOfPriceTable(String value) {
        questPrice.shouldHave(text(value));

        return this;
    }

    //проверки для теста testFiltersOnTheMainPage
    public PageObject selectValueFromTheDropdownList(String value) {
        $(byText(value)).click();

        return this;
    }
    public PageObject selectQuestData(String value) {
        firstDateFromTheList.$(byText(value)).sibling(2).click();

        return this;
    }
    public PageObject resultsTableOpened(SelenideElement table, String value) {
        table.should(appear);
        table.shouldHave(text(value));

        return this;
    }
    public PageObject questTypeCheck(String value) {
        anyQuestFromTheList.click();
        switchTo().window(1);
        questParameters.shouldHave(text(value));

        return this;
    }

    //проверки для тестов класса QuestPageTests
    public PageObject checkingForBlockPresence(SelenideElement block, String header, String content) {
        block.shouldHave(text(header));
        block.shouldHave(text(content));

        return this;
    }

    //проверки для тестов класса SortingQuestsTests
    public PageObject selectSorting(String value) {
        sortMenu.click();
        $(".sort__dropdown").$(byText(value)).click();

        return this;
    }
    public PageObject checkThePopularityOfTheQuest() {
        $(anyQuestFromTheList).click();
        String teamsPassedTheQuest = numberOfTeams.getText();

        teamsPassedTheQuest = teamsPassedTheQuest.substring(0, teamsPassedTheQuest.indexOf(" "));
        int numberOfTeams = Integer.parseInt(teamsPassedTheQuest);
        Assert.isTrue(numberOfTeams > 900, "Квест из результатов сортировки не является популярным");

        return this;
    }
    public PageObject checkTheRatingOfTheQuest(String value) {
        $(anyQuestFromTheList).click();
        questRating.shouldHave(text(value));

        return this;
    }

    //для тестов класса QuestComparisonTests
    public PageObject addQuestToComparisonPage(int value) {
        questCompareBtn.get(value).click();

        return this;
    }
    public PageObject openComparisonPage (String value) {
        open(value);
        return this;
    }
    public PageObject checkThatTwoQuestsInTheComparisonTable () {
        questInTableResults.shouldHave(size(2));

        return this;
    }
}
