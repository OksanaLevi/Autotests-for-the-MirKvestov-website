package ru.mirkvwstov.pages;

import com.codeborne.selenide.ElementsCollection;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Selenide.$$;

public class ComparisonPage {

    private final ElementsCollection
            questInTableResults = $$(".owl-item");


    public ComparisonPage checkThatTwoQuestsInTheComparisonTable() {
        questInTableResults.shouldHave(size(2));

        return this;
    }
}
