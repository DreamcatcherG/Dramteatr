package snoonu.utils_generate;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;
import static snoonu.helpers.DriverHelper.byTestId;

public class Auth {

    public static void fillForm230() {  // Auth.fillForm230();

        step("Login with 230", () -> {

            if ($(byName("phoneNumber")).exists()) {

                $(byName("phoneNumber")).sendKeys("21343230");
                $(byTestId("loginContinue")).click();
                AwtRobot.entOtp();

            } else {

                $(byTestId("loginButton")).click();
                $(byName("phoneNumber")).click();
                $(byName("phoneNumber")).sendKeys("21343230");
                $(byTestId("loginContinue")).click();
                AwtRobot.entOtp();

            }

        });

    }

    public static void fillform272() { //  Auth.fillForm272();

        step("Login with 272", () -> {

            if ($(byName("phoneNumber")).exists()) {

                $(byName("phoneNumber")).sendKeys("21343272");
                $(byTestId("loginContinue")).click();
                AwtRobot.entOtp();

            } else {

                $(byTestId("loginButton")).click();
                $(byName("phoneNumber")).click();
                $(byName("phoneNumber")).sendKeys("21343272");
                $(byTestId("loginContinue")).click();
                AwtRobot.entOtp();

            }

        });

    }


    public static void fillform276() { //  Auth.fillForm276(); ordering only

        step("Login with 276", () -> {

            if ($(byName("phoneNumber")).exists()) {

                $(byName("phoneNumber")).sendKeys("21343276");
                $(byTestId("loginContinue")).click();
                AwtRobot.entOtp();

            } else {

                $(byTestId("loginButton")).click();
                $(byName("phoneNumber")).click();
                $(byName("phoneNumber")).sendKeys("21343276");
                $(byTestId("loginContinue")).click();
                AwtRobot.entOtp();

            }

        });

    }

    public static void fillform285() { //  Auth.fillForm285();

        step("Login with 285", () -> {

            if ($(byName("phoneNumber")).exists()) {

                $(byName("phoneNumber")).sendKeys("21343285");
                $(byTestId("loginContinue")).click();
                AwtRobot.entOtp();

            } else {

                $(byTestId("loginButton")).click();
                $(byName("phoneNumber")).click();
                $(byName("phoneNumber")).sendKeys("21343285");
                $(byTestId("loginContinue")).click();
                AwtRobot.entOtp();

            }

        });

    }

    public static void fillForm286() {  // Auth.fillForm286();

        step("Login with 286", () -> {

            if ($(byName("phoneNumber")).exists()) {

                $(byName("phoneNumber")).sendKeys("21343286");
                $(byTestId("loginContinue")).click();
                AwtRobot.entOtp();

            } else {

                $(byTestId("loginButton")).click();
                $(byName("phoneNumber")).click();
                $(byName("phoneNumber")).sendKeys("21343286");
                $(byTestId("loginContinue")).click();
                AwtRobot.entOtp();

            }

        });

    }

    public static void fillForm336() {  // Auth.fillForm336();

        step("Login with 336", () -> {

            if ($(byName("phoneNumber")).exists()) {

                $(byName("phoneNumber")).sendKeys("21343336");
                $(byTestId("loginContinue")).click();
                AwtRobot.entOtp();

            } else {

                $(byTestId("loginButton")).click();
                $(byName("phoneNumber")).click();
                $(byName("phoneNumber")).sendKeys("21343336");
                $(byTestId("loginContinue")).click();
                AwtRobot.entOtp();

            }

        });
    }

}
