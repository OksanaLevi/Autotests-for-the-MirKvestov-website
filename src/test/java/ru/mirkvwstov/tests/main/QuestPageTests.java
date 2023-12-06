package ru.mirkvwstov.tests.main;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.*;
import org.junit.jupiter.api.*;
import ru.mirkvwstov.pages.QuestPage;
import ru.mirkvwstov.tests.TestBase;
import ru.mirkvwstov.utils.TestData;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.executeJavaScript;
import static io.qameta.allure.Allure.step;

@Epic("Страница квеста")
@Story("Оформление блоков на странице квеста")
@Owner("Левинская Оксана")
public class QuestPageTests extends TestBase {

    private final String
            questUrl = "quests/quest-stars-the-astral",
            descriptionQuest = "Вы – группа друзей, которая жаждет погрузиться в астрал",
            timeQuest = "10:00",
            contactsQuest = " м.";
    private final SelenideElement
            descriptionBlock = $("#description"),
            reservationBlock = $("#timetable"),
            contactsBlock = $("#contacts");
    QuestPage questPage = new QuestPage();
    TestData testData = new TestData();

    @Test
    @Tags({
            @Tag("smoke"),
            @Tag("quest")
    })
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Проверка наличия обязательных блоков на странице квеста")
    void testForThePresenceOfRequiredBlocks() {

        step("Открыть страницу", () -> {
            questPage.openPage(questUrl);
        });
        step("Проверка блока с описанием квеста", () -> {
            questPage.checkingForBlockPresence(descriptionBlock, testData.blockTitleWithDescription, descriptionQuest);
        });
        step("Проверка блока с расписанием квестов", () -> {
            questPage.checkingForBlockPresence(reservationBlock, testData.blockTitleWithReservation, timeQuest);
        });
        step("Проверка блока с контактами квеста", () -> {
            questPage.checkingForBlockPresence(contactsBlock, testData.blockTitleWithContacts, contactsQuest);
        });
    }

    @BeforeEach
    void beforeEach() {
        Selenide.open(questUrl);
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");
    }
}
