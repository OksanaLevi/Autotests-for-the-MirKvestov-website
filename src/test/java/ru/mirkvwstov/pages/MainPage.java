package ru.mirkvwstov.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import dev.failsafe.internal.util.Assert;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class MainPage {

    private final SelenideElement
            headerMainPage = $("h1"),
            filterQuestType = $("#search-form"),
            questSearchButton = $(".row"),
            firstDateFromTheList = $("#date"),
            eventType = $(".game-type"),
            questPrice = $(".timetable"),
            questParameters = $(".masthead"),
            anyQuestFromTheList = $(".quest-tile-1"),
            sortMenu = $(".sort__select"),
            numberOfTeams = $(".quest-rating-populi .quest-rating-populi__team-count_number"),
            questRating = $(".quest-rating-populi__value");
    private final ElementsCollection
            questPage = $$(".quest-tile-1"),
            questCompareBtn = $$(".js-quest-compare-btn");


    public MainPage checkHeaderOnMainPage(String value) {
        headerMainPage.shouldHave(text(value));

        return this;
    }
    public MainPage checkingForFilterPresence(String value) {
        filterQuestType.shouldHave(text(value));

        return this;
    }
    public MainPage findQuestUsingSpecifiedFilters(String value) {
        questSearchButton.shouldHave(text(value));

        return this;
    }
    public MainPage goToQuestPage(int value) {
        questPage.get(value).click();

        return this;
    }
    public MainPage checkHeaderOnPageQuest(String quest) {
        eventType.shouldHave(text(quest));

        return this;
    }
    public MainPage checkingAvailabilityOfPriceTable(String value) {
        questPrice.shouldHave(text(value));

        return this;
    }

    public MainPage selectValueFromTheDropdownList(String value) {
        $(byText(value)).click();

        return this;
    }
    public MainPage selectQuestData(String value) {
        firstDateFromTheList.$(byText(value)).sibling(2).click();

        return this;
    }
    public MainPage resultsTableOpened(SelenideElement table, String value) {
        table.should(appear);
        table.shouldHave(text(value));

        return this;
    }
    public MainPage questTypeCheck(String value) {
        anyQuestFromTheList.click();
        switchTo().window(1);
        questParameters.shouldHave(text(value));

        return this;
    }

    public MainPage selectSorting(String value) {
        sortMenu.click();
        $(".sort__dropdown").$(byText(value)).click();

        return this;
    }
    public MainPage checkThePopularityOfTheQuest() {
        $(anyQuestFromTheList).click();
        String teamsPassedTheQuest = numberOfTeams.getText();

        teamsPassedTheQuest = teamsPassedTheQuest.substring(0, teamsPassedTheQuest.indexOf(" "));
        int numberOfTeams = Integer.parseInt(teamsPassedTheQuest);
        Assert.isTrue(numberOfTeams > 900, "Квест из результатов сортировки не является популярным");

        return this;
    }
    public MainPage checkTheRatingOfTheQuest(String value) {
        $(anyQuestFromTheList).click();
        questRating.shouldHave(text(value));

        return this;
    }

    public MainPage addQuestToComparisonPage(int value) {
        questCompareBtn.get(value).click();

        return this;
    }
    public MainPage openComparisonPage (String value) {
        open(value);
        return this;
    }
}
