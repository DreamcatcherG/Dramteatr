package snoonu.utils_generate;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class XPathUtil {


    public static void checkBtnTxt() {
//          Waiting the loading of Checkout button in the cart
        $(byXpath("//h5[text()='Checkout']")).shouldHave(text("Checkout"));

    }

    public static void PayСardField() {
//          Field for Credit cards in saved cards window
        $(byXpath("/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]")).shouldHave(text("•••• 1111"));

    }

    public static void СardDelBut() {
//          Delete button for Credit cards in saved cards window
        $(byXpath("/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/span[1]/span[1]/img[1]")).click();

    }

    public static void Close3DS() {
//          Close btn on the 3ds page
        $(byXpath("/html[1]/body[1]/div[2]/div[2]/div[1]/div[1]/div[1]/span[1]/span[1]/img[1]")).click();

    }

    public static void CloseLocWin() {
//          Close btn on the 3ds page
        $(byXpath("/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/div[1]/span[1]/span[1]/img[1]")).click();

    }

    public static void ArrLoc() {
//          Close btn on the 3ds page
        $(byXpath("/html[1]/body[1]/div[1]/div[1]/header[1]/div[1]/div[3]/div[1]/div[1]/span[2]/span[1]")).shouldBe(appear);

    }

    public static void ProdImage() {
//          Close btn on the 3ds page
        $(byXpath("/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/span[1]/img[1]")).shouldBe(appear);

    }

    public static void ConfirmRDel() {
//          Close btn on the 3ds page
        $(byXpath("/html[1]/body[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[2]/button[1]")).click();


    }
}
// $(byClassName("SearchButton_button__8GVDU")).click();  Search button -
//        Wrong code message
//        $(byXpath("/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/div[1]/form[1]/div[1]/p[1]")).exists()

//