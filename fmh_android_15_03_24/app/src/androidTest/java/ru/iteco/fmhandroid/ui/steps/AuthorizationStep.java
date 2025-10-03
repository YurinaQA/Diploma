package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.matcher.ViewMatchers.isAssignableFrom;
import static androidx.test.espresso.matcher.ViewMatchers.isDescendantOfA;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

import android.widget.EditText;

import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.utils.AllureStep;

public class AuthorizationStep {

    /** Ввод логина */
    public void loginFieldInput(String input) {
        AllureStep.step("Ввод логина: " + input, () ->
                onView(allOf(
                        isDescendantOfA(withId(R.id.login_text_input_layout)),
                        isAssignableFrom(EditText.class)))
                        .perform(replaceText(input))
        );
    }

    /** Ввод пароля */
    public void passwordFieldInput(String input) {
        AllureStep.step("Ввод пароля: " + input, () ->
                onView(allOf(
                        isDescendantOfA(withId(R.id.password_text_input_layout)),
                        isAssignableFrom(EditText.class)))
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
                onView(withText(R.string.authorization))
                        .check((view, noViewFoundException) -> {
                            if (noViewFoundException != null) throw noViewFoundException;
                        })
        );
    }

    /** Проверка сообщения об ошибке */
    public void checkErrorMessage(int messageResId) {
        AllureStep.step("Проверка сообщения об ошибке", () ->
                onView(withText(messageResId))
                        .check((view, noViewFoundException) -> {
                            if (noViewFoundException != null) throw noViewFoundException;
                        })
        );
    }
}
