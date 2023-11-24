package ru.mirkvwstov.tests.pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;
import ru.mirkvwstov.pages.PageObject;
import ru.mirkvwstov.tests.TestBase;
import ru.mirkvwstov.utils.TestData;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.executeJavaScript;
import static io.qameta.allure.Allure.step;

@Epic("Страница квеста")
@Story("Оформление блоков на странице квеста")
@Owner("Левинская Оксана")
public class QuestPageTests extends TestBase {

    PageObject pageObject = new PageObject();
    TestData testData = new TestData();

    //Параметры проверяемой страницы квеста
    private final String
            questUrl = "/quests/quest-stars-the-astral",
            descriptionQuest = "Вы – группа друзей, которая жаждет погрузиться в астрал",
            timeQuest = "10:00",
            contactsQuest = " м.";
    private final SelenideElement
            descriptionBlock = $("#description"),
            reservationBlock = $("#timetable"),
            contactsBlock = $("#contacts");

    @Test
    @Tags({
            @Tag("smoke"),
            @Tag("quest")
    })
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Проверка наличия обязательных блоков на странице квеста")
    void testForThePresenceOfRequiredBlocks() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Проверка блока с описанием квеста", () -> {
            pageObject.checkingForBlockPresence(descriptionBlock, testData.blockTitleWithDescription, descriptionQuest);
        });
        step("Проверка блока с расписанием квестов", () -> {
            pageObject.checkingForBlockPresence(reservationBlock, testData.blockTitleWithReservation, timeQuest);
        });
        step("Проверка блока с контактами квеста", () -> {
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
