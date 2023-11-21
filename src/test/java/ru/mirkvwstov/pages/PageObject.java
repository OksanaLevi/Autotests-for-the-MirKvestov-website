package ru.mirkvwstov.pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class PageObject {
    SelenideElement
    //на главной странице
            headerMainPage = $("h1"),
            filterQuestType = $("#search-form"),
            questSearchButton = $(".row"),
    //на странице квеста
            questPage =  $(".quests-popular .quest-tile-1__title"),
            headerQuestPage = $("h1"),
            questPrice = $(".timetable");




    // проверки для теста testOfRequiredElementsOnTheMainPage

    public PageObject checkHeaderOnMainPage (String value) {
        headerMainPage.shouldHave(text(value));

        return this;
    }

    public PageObject checkingForFilterPresence (String value) {
        filterQuestType.shouldHave(text(value));

        return this;
    }

    public PageObject findQuestUsingSpecifiedFilters (String value) {
        questSearchButton.shouldHave(text(value));

        return this;
    }

    public PageObject goToQuestPage (String value) {
        questPage.$(byText(value)).click();

        return this;
    }

    public PageObject checkHeaderOnPageQuest (String value) {
        headerQuestPage.shouldHave(text(value));

        return this;
    }

    public PageObject checkingAvailabilityOfPriceTable (String value) {
        questPrice.shouldHave(text(value));

        return this;
    }

    // проверки для теста testFiltersOnTheMainPage

    public PageObject selectValueFromTheDropdownList (String value) {
        $(byText(value)).click();

        return this;
    }

}