package ru.mirkvwstov.pages;

import com.codeborne.selenide.SelenideElement;
import dev.failsafe.internal.util.Assert;

import javax.xml.xpath.XPath;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PageObject {
    SelenideElement
    //на главной странице
            headerMainPage = $("h1"),
            filterQuestType = $("#search-form"),
            questSearchButton = $(".row"),
            firstDateFromTheList = $("#date"),
            resultsSearch = $("#search-form"),
            sortMenu = $(".sort__select"),
            numberOfTeams = $(".quest-rating-populi .quest-rating-populi__team-count_number"),
    //на странице квеста
            questPage = $(".quests-popular .quest-tile-1__title"),
            headerQuestPage = $("h1"),
            questPrice = $(".timetable"),
            questParameters = $(".masthead"),
            questRating = $(".quest-rating-populi__value"),
    //на странице с результатами поиска
            anyQuestFromTheList = $(".quest-tile-1");
//    XPath sortMenu = //*[contains(@class, 'sort__dropdown')]//*[contains(text(), 'Народный рейтинг')];


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
    public PageObject goToQuestPage(String value) {
        questPage.$(byText(value)).click();

        return this;
    }
    public PageObject checkHeaderOnPageQuest(String value) {
        headerQuestPage.shouldHave(text(value));

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
    public PageObject resultsTableOpened() {
        resultsSearch.should(appear);
        resultsSearch.shouldHave(text("Тип игры"));

        return this;
    }
    public PageObject questTypeCheck(String value) {
        anyQuestFromTheList.click();
        switchTo().window(1);
        questParameters.shouldHave(text(value));

        return this;
    }

    //проверки для теста testForThePresenceOfRequiredBlocks
    public PageObject checkingForBlockPresence(SelenideElement block, String header, String content) {
        block.shouldHave(text(header));
        block.shouldHave(text(content));

        return this;
    }

    //проверки для теста sortingQuestsByPopularity
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
}
