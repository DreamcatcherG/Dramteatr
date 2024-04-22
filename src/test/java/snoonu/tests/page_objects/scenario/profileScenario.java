package snoonu.tests.page_objects.scenario;

import snoonu.helpers.Css;
import snoonu.tests.TestData;
import snoonu.tests.page_objects.pages.mainPageObjects;
import snoonu.tests.page_objects.pages.profileObjects;
import snoonu.utils_generate.TextGenerator;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class profileScenario {

    public static void goToSavedPaymentsCard() {
        mainPageObjects.profileIcon().click();
        profileObjects.paymentCards().click();
        assert profileObjects.addPaymentCardBtn().isDisplayed();
    }

    public static void goToProfile() {
        mainPageObjects.profileIcon().click();
    }

    public static void assertNoSavedCards() {
        sleep(3000);

        // Проверяем, появилась ли кнопка удаления сохраненных карт
        if (profileObjects.deleteSavedCardBtn().exists()) {

            // Пока кнопка удаления сохраненных карт существует, выполняем следующие шаги
            while (profileObjects.deleteSavedCardBtn().exists()) {
                profileObjects.deleteSavedCardBtn().click();
                profileObjects.confirmDeleteBtn().shouldBe(appear).click();
                profileObjects.confirmDeleteBtn().should(disappear);
            }
        } else {
            sleep(2000);
            profileObjects.isPaymentCard().shouldHave(text("You do not have any saved cards at the moment"));
        }
    }

    public static void addNewPayCard(String cardNumber) {
        profileObjects.addPaymentCardBtn().click();
        profileObjects.cardNumberField(cardNumber);
//      Date
        int month = TextGenerator.getRandomNumber(1, 12);
        int year = TextGenerator.getRandomNumber(28, 99);
        String formattedMonth = String.format("%02d", month);
        String formattedYear = String.format("%02d", year);
        profileObjects.expiryDateField().setValue(formattedMonth + formattedYear);
//      Cvv
        int randomCvv = TextGenerator.getRandomNumber(1, 999);
        profileObjects.cvvField().setValue(String.format("%03d", randomCvv));

        profileObjects.saveCardBtn().click();
        profileObjects.saveCardBtn().should(disappear);
    }

    public static void completePayCardAdding() {
        profileObjects.Frame3ds().shouldBe(visible);
        switchTo().frame(profileObjects.Frame3ds());
        profileObjects.submitBtn3Ds().click();
        sleep(3000);
        switchTo().defaultContent();
        profileObjects.close3DS().click();
    }
        public static void assertCardMatched() {
            String lastFourDigits = TestData.CreditCard.substring(TestData.CreditCard.length() - 4); // Получаем последние четыре цифры карты из TestData
//            System.out.println("Last four digits of the test card: " + lastFourDigits);
            String displayedText = $(Css.byId("credit-card-list-credit-card-number")).getText(); // Получаем отображаемый текст с веб-страницы
//            System.out.println("Displayed text on the web page: " + displayedText);
            String displayedLastFourDigits = displayedText.substring(displayedText.length() - 4); // Получаем последние четыре цифры из отображаемого текста
//            System.out.println("Last four digits displayed on the web page: " + displayedLastFourDigits);

            // Проверяем, совпадают ли последние четыре цифры карты из TestData с последними четырьмя цифрами отображаемого текста
            assertEquals(lastFourDigits, displayedLastFourDigits, "Last four digits of the card do not match the displayed text");
        }
}




