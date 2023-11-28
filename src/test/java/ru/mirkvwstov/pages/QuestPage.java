package ru.mirkvwstov.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;

public class QuestPage {
    public QuestPage checkingForBlockPresence(SelenideElement block, String header, String content) {
        block.shouldHave(text(header));
        block.shouldHave(text(content));

        return this;
    }
}
