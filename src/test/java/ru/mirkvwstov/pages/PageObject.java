package ru.mirkvwstov.pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class PageObject {
    SelenideElement
            headerMainPage = $("h1"),
            filterQuestType = $("#search-form"),
            questSearchButton = $(".row");


    public PageObject openPage() {
        Selenide.open("https://mir-kvestov.ru/");
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");

        return this;
    }

    public PageObject checkHeader (String value) {
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
}
