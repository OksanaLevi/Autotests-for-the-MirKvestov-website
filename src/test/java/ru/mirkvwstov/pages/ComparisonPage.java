package ru.mirkvwstov.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import dev.failsafe.internal.util.Assert;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class ComparisonPage {

    private final ElementsCollection
            questInTableResults  = $$(".owl-item");


    public ComparisonPage checkThatTwoQuestsInTheComparisonTable () {
        questInTableResults.shouldHave(size(2));

        return this;
    }
}
