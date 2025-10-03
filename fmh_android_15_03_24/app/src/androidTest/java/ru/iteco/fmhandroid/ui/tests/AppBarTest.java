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
public class AppBarTest extends DataGenerator {

    private final AuthorizationStep authorizationStep = new AuthorizationStep();
    private final AppBarStep appBarStep = new AppBarStep();

    @Rule
    public ActivityScenarioRule<AppActivity> activityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);

    private final String NEWS_PAGE_TITLE = "ALL NEWS";      // заголовок страницы Новости

    @Before
    public void login() {
        try {
            appBarStep.checkNewsPageTitle(NEWS_PAGE_TITLE);
        } catch (Exception e) {
            authorizationStep.loginFieldInput(validLogin);
            authorizationStep.passwordFieldInput(validPassword);
            authorizationStep.clickLoginBtn();
        }
        appBarStep.checkNewsPageTitle(NEWS_PAGE_TITLE);
    }

    @Test
    @Story("Навигация: пункт 'О приложении' кликабелен")
    public void testNavigationAboutIsClickable() {
        appBarStep.clickNavigationBtn();
        appBarStep.clickNavigationAbout();
    }

    @Test
    @Story("Навигация: переход на страницу Новости")
    public void testNavigationNews() {
        appBarStep.clickNavigationBtn();
        appBarStep.clickNavigationNews();
        appBarStep.checkNewsPageTitle(NEWS_PAGE_TITLE);
    }

    @Test
    @Story("Навигация: переход на главную страницу")
    public void testNavigationMain() {
        appBarStep.clickNavigationBtn();
        appBarStep.clickNavigationMain();
        appBarStep.checkMainPage();
    }

    @Test
    @Story("Кнопка 'Love is All' открывает соответствующую страницу")
    public void testLoveIsAllButton() {
        appBarStep.clickLoveIsAllBtn();
        appBarStep.checkLoveIsAllTitle();
    }

    @Test
    @Story("Выход из приложения возвращает на страницу авторизации")
    public void testExitApp() {
        appBarStep.exit();
        authorizationStep.checkAuthorizationPage();
    }
}
