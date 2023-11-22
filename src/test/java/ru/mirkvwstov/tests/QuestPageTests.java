package ru.mirkvwstov.tests;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.*;
import ru.mirkvwstov.pages.PageObject;
import ru.mirkvwstov.tests.TestBase;
import ru.mirkvwstov.utils.TestData;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.executeJavaScript;
import static io.qameta.allure.Allure.step;

public class QuestPageTests extends TestBase {

    PageObject pageObject = new PageObject();
    TestData testData = new TestData();

//Параметры проверяемой страницы квеста
    String questUrl = "/quests/quest-stars-the-astral",
            descriptionQuest = "Вы – группа друзей, которая жаждет погрузиться в астрал",
            timeQuest = "10:00",
        contactsQuest = " м.";
    SelenideElement
            descriptionBlock = $("#description"),
            reservationBlock = $("#timetable"),
            contactsBlock = $("#contacts");

    @Test
    @Tags({
            @Tag("smoke"),
            @Tag("quest")
    })
    @DisplayName("Checking for required quest blocks")
    void testForThePresenceOfRequiredBlocks() {
        step("Checking the presence of a block with a description of the quest", () -> {
            pageObject.checkingForBlockPresence(descriptionBlock, testData.blockTitleWithDescription, descriptionQuest);
        });
        step("Checking the availability of a block with a schedule quest", () -> {
            pageObject.checkingForBlockPresence(reservationBlock, testData.blockTitleWithReservation, timeQuest);
        });
        step("Checking the presence of a block with quest contacts", () -> {
            pageObject.checkingForBlockPresence(contactsBlock, testData.blockTitleWithContacts, contactsQuest);
        });
    }

    @BeforeEach
    void beforeEach() {
        Selenide.open(questUrl);
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");
    }
}
