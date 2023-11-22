package ru.mirkvwstov.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
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
    //на странице квеста
            questPage = $(".quests-popular .quest-tile-1__title"),
            headerQuestPage = $("h1"),
            questPrice = $(".timetable"),
            questParameters = $(".masthead"),
    //на странице с результатами поиска
            anyQuestFromTheList = $(".quest-tile-1");


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
}