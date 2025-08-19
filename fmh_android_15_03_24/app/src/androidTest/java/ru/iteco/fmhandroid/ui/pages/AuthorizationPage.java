package ru.iteco.fmhandroid.ui.pages;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.RootMatchers.withDecorView;
import static androidx.test.espresso.matcher.ViewMatchers.isDescendantOfA;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.supportsInputMethods;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.not;

import android.view.View;

import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;

public class AuthorizationPage {

    // ID элементов
    public final int LOGIN_FIELD_LAYOUT_ID = R.id.login_text_input_layout;
    public final int PASSWORD_FIELD_LAYOUT_ID = R.id.password_text_input_layout;
    public final int LOGIN_BUTTON_ID = R.id.enter_button;

    // Текст заголовка страницы
    public final String AUTHORIZATION_TITLE_TEXT = "Authorization";

    /** Layout поля логина */
    public ViewInteraction getLoginFieldLayout() {
        return onView(withId(LOGIN_FIELD_LAYOUT_ID));
    }

    /** Поле ввода логина */
    public ViewInteraction getLoginTextField() {
        return onView(allOf(
                supportsInputMethods(),
                isDescendantOfA(withId(LOGIN_FIELD_LAYOUT_ID))
        ));
    }

    /** Layout поля пароля */
    public ViewInteraction getPasswordFieldLayout() {
        return onView(withId(PASSWORD_FIELD_LAYOUT_ID));
    }

    /** Поле ввода пароля */
    public ViewInteraction getPasswordTextField() {
        return onView(allOf(
                supportsInputMethods(),
                isDescendantOfA(withId(PASSWORD_FIELD_LAYOUT_ID))
        ));
    }

    /** Кнопка входа */
    public ViewInteraction getLoginButton() {
        return onView(withId(LOGIN_BUTTON_ID));
    }

    /** Заголовок страницы "Authorization" */
    public ViewInteraction getAuthorizationText() {
        return onView(withText(AUTHORIZATION_TITLE_TEXT));
    }

    /** Проверка отображения сообщения об ошибке */
    public static void checkErrorMessageDisplayed(String text, View decorView) {
        onView(withText(text))
                .inRoot(withDecorView(not(decorView)))
                .check(matches(isDisplayed()));
    }
}
