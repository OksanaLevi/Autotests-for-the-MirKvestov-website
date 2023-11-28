package ru.mirkvwstov.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import dev.failsafe.internal.util.Assert;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class QuestPage {
    public QuestPage checkingForBlockPresence(SelenideElement block, String header, String content) {
        block.shouldHave(text(header));
        block.shouldHave(text(content));

        return this;
    }
}
