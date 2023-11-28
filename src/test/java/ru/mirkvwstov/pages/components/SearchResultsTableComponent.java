package ru.mirkvwstov.pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class SearchResultsTableComponent {
    SelenideElement tableResult = $("#search-form");

    public SearchResultsTableComponent searchResultsForm(String value) {
        tableResult.shouldHave(text(value));

        return this;
    }
}
