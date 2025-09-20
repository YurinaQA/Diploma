package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import com.google.android.material.textfield.TextInputEditText;

import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.utils.AllureStep;

public class AuthorizationStep {

    /** Ввод логина */
    public void loginFieldInput(String input) {
        AllureStep.step("Ввод логина: " + input, () ->
                onView(withId(R.id.login_text_input_layout))
                        .perform(replaceText(input))
        );
    }

    /** Ввод пароля */
    public void passwordFieldInput(String input) {
        AllureStep.step("Ввод пароля: " + input, () ->
                onView(withId(R.id.password_text_input_layout))
                        .perform(replaceText(input))
        );
    }

    /** Клик по кнопке входа */
    public void clickLoginBtn() {
        AllureStep.step("Нажатие кнопки входа", () ->
                onView(withId(R.id.enter_button)).perform(click())
        );
    }

    /** Проверка, что отображается страница авторизации */
    public void checkAuthorizationPage() {
        AllureStep.step("Проверка отображения страницы авторизации", () ->
                onView(withText("Authorization")).check((view, noViewFoundException) -> {
                    if (noViewFoundException != null) throw noViewFoundException;
                })
        );
    }

    /** Проверка отображения сообщения об ошибке */
    public void checkErrorMessage(String message) {
        AllureStep.step("Проверка сообщения об ошибке: " + message, () ->
                onView(withText(message)).check((view, noViewFoundException) -> {
                    if (noViewFoundException != null) throw noViewFoundException;
                })
        );
    }
}
