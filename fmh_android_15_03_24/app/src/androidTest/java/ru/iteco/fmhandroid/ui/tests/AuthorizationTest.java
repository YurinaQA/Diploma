package ru.iteco.fmhandroid.ui.tests;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.filters.LargeTest;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.Story;
import ru.iteco.fmhandroid.ui.AppActivity;
import ru.iteco.fmhandroid.ui.data.DataGenerator;
import ru.iteco.fmhandroid.ui.steps.AppBarStep;
import ru.iteco.fmhandroid.ui.steps.AuthorizationStep;

@LargeTest
@RunWith(AllureAndroidJUnit4.class)
public class AuthorizationTest extends DataGenerator {

    private final AuthorizationStep authorizationStep = new AuthorizationStep();
    private final AppBarStep appBarStep = new AppBarStep();

    @Rule
    public ActivityScenarioRule<AppActivity> activityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);

    @Before
    public void ensureOnAuthorizationPage() {
        try {
            // Проверяем открыта ли главная страница (значит, пользователь авторизован)
            appBarStep.checkNewsPageTitle();
            // Если авторизован — разлогиниваем
            appBarStep.exit();
        } catch (Exception e) {
            // Если не авторизован — уже на странице авторизации
            authorizationStep.checkAuthorizationPage();
        }
    }

    @Test
    @Story("Авторизация с валидными данными")
    public void userShouldAuthorizeWithValidCredentials() {
        authorizationStep.loginFieldInput(validLogin);
        authorizationStep.passwordFieldInput(validPassword);
        authorizationStep.clickLoginBtn();
        appBarStep.checkNewsPageTitle();
    }

    @Test
    @Story("Авторизация без ввода логина и пароля")
    public void shouldNotAuthorizeWithEmptyFields() {
        authorizationStep.clickLoginBtn();
        authorizationStep.checkAuthorizationPage();
    }

    @Test
    @Story("Авторизация только с логином без пароля")
    public void shouldNotAuthorizeWithLoginOnly() {
        authorizationStep.loginFieldInput(validLogin);
        authorizationStep.clickLoginBtn();
        authorizationStep.checkAuthorizationPage();
    }

    @Test
    @Story("Авторизация только с паролем без логина")
    public void shouldNotAuthorizeWithPasswordOnly() {
        authorizationStep.passwordFieldInput(validPassword);
        authorizationStep.clickLoginBtn();
        authorizationStep.checkAuthorizationPage();
    }

    @Test
    @Story("Авторизация с неверными данными")
    public void shouldNotAuthorizeWithInvalidCredentials() {
        authorizationStep.loginFieldInput("wrongLogin");
        authorizationStep.passwordFieldInput("wrongPass123");
        authorizationStep.clickLoginBtn();
        authorizationStep.checkAuthorizationPage();
    }
}
