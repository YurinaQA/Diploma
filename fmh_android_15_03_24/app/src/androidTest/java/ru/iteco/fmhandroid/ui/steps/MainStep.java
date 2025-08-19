package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import io.qameta.allure.kotlin.Step;
import ru.iteco.fmhandroid.ui.WaitId;
import ru.iteco.fmhandroid.ui.pages.MainPage;

/**
 * Класс содержит шаги взаимодействия с главным экраном приложения.
 */
public class MainStep {

    private final MainPage mainPage = new MainPage();

    @Step("Нажать кнопку сворачивания/разворачивания ленты новостей")
    public void clickOpenNewsBtn() {
        WaitId.waitUntilElement(mainPage.EXPAND_NEWS_BUTTON_ID);
        mainPage.getOpenNewsButton().check(matches(isDisplayed())).perform(click());
    }

    @Step("Проверить отображение текста 'ALL NEWS' на главной странице")
    public void checkAllNewsText() {
        WaitId.waitUntilElement(mainPage.ALL_NEWS_TEXT_VIEW_ID);
        mainPage.getAllNewsText().check(matches(isDisplayed()));
        mainPage.getAllNewsText().check(matches(withText(mainPage.ALL_NEWS_TEXT)));
    }

    @Step("Перейти на страницу всех новостей через кнопку 'ALL NEWS'")
    public void clickAllNewsText() {
        WaitId.waitUntilElement(mainPage.ALL_NEWS_TEXT_VIEW_ID);
        mainPage.getAllNewsButton().check(matches(isDisplayed())).perform(click());
    }

    @Step("Проверить заголовок ленты новостей на главной странице")
    public void checkNewsTitle() {
        WaitId.waitUntilElement(mainPage.NEWS_FEED_CONTAINER_ID);
        mainPage.getNewsFeedTitle().check(matches(isDisplayed()));
    }
}
