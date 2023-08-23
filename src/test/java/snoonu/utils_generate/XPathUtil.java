package snoonu.utils_generate;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static snoonu.helpers.DriverHelper.byTestId;

public class XPathUtil {



    public static void checkBtnTxt() {
//          Waiting the loading of Checkout button in the cart
        $(byXpath("//h5[text()='Checkout']")).shouldHave(text("Checkout"));

    }

}

//      Need change Id for Done button on the choosing payment method window
//      $(byText("Done")).click();
//      $x("/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/div[1]/form[1]/button[2]").shouldBe(visible).click();