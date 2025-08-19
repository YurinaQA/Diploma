package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.ui.WaitId;
import ru.iteco.fmhandroid.ui.pages.AuthorizationPage;

public class AuthorizationStep {

    private final AuthorizationPage authorizationPage;

    public AuthorizationStep() {
        this.authorizationPage = new AuthorizationPage();
    }

    public void loginFieldInput(String input) {
        Allure.step("Ввод логина: " + input, () -> {
            WaitId.waitUntilElement(authorizationPage.LOGIN_FIELD_LAYOUT_ID);
            authorizationPage.getLoginTextField().perform(click());
            authorizationPage.getLoginTextField().perform(replaceText(input), closeSoftKeyboard());
            authorizationPage.getLoginFieldLayout().check(matches(isDisplayed()));
        });
    }

    public void passwordFieldInput(String input) {
        Allure.step("Ввод пароля: " + input, () -> {
            WaitId.waitUntilElement(authorizationPage.PASSWORD_FIELD_LAYOUT_ID);
            authorizationPage.getPasswordTextField().perform(click());
            authorizationPage.getPasswordTextField().perform(replaceText(input), closeSoftKeyboard());
            authorizationPage.getPasswordFieldLayout().check(matches(isDisplayed()));
        });
    }

    public void clickLoginBtn() {
        Allure.step("Нажатие кнопки входа", () -> {
            authorizationPage.getLoginButton().check(matches(isDisplayed()));
            authorizationPage.getLoginButton().perform(click());
        });
    }

    public void checkAuthorizationPage() {
        Allure.step("Проверка отображения страницы авторизации", () -> {
            WaitId.waitUntilElement(authorizationPage.AUTHORIZATION_TITLE_TEXT);
            authorizationPage.getAuthorizationText().check(matches(isDisplayed()));
        });
    }

    public void checkErrorMessage(String message) {
        Allure.step("Проверка отображения сообщения об ошибке: " + message, () -> {
            authorizationPage.checkErrorMessageDisplayed(message, null);
        });
    }
}
