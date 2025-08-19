package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import io.qameta.allure.kotlin.Step;
import ru.iteco.fmhandroid.ui.WaitId;
import ru.iteco.fmhandroid.ui.data.DataGenerator;
import ru.iteco.fmhandroid.ui.pages.AppBarPage;
import ru.iteco.fmhandroid.ui.pages.LoveIsAllPage;
import ru.iteco.fmhandroid.ui.pages.NewsPage;

public class AppBarStep extends DataGenerator {

    private final AppBarPage appBarPage;
    private final LoveIsAllPage loveIsAllPage;
    private final NewsPage newsPage;

    public AppBarStep() {
        this.appBarPage = new AppBarPage();
        this.loveIsAllPage = new LoveIsAllPage();
        this.newsPage = new NewsPage();
    }

    @Step("Нажатие кнопки навигации")
    public void clickNavigationBtn() {
        WaitId.waitUntilElement(appBarPage.NAVIGATION_BUTTON_ID);
        appBarPage.getNavigationButton().check(matches(isDisplayed()));
        appBarPage.getNavigationButton().perform(appBarPage.click());
    }

    @Step("Переход в раздел 'News'")
    public void clickNavigationNews() {
        WaitId.waitUntilElement(appBarPage.NAVIGATION_NEWS_ID);
        appBarPage.getNavigationNews().check(matches(isDisplayed()));
        appBarPage.getNavigationNews().perform(appBarPage.click());
    }

    @Step("Переход в раздел 'About'")
    public void clickNavigationAbout() {
        WaitId.waitUntilElement(appBarPage.NAVIGATION_ABOUT_ID);
        appBarPage.getNavigationAbout().check(matches(isDisplayed()));
        appBarPage.getNavigationAbout().perform(appBarPage.click());
    }

    @Step("Переход на главную страницу")
    public void clickNavigationMain() {
        WaitId.waitUntilElement(appBarPage.NAVIGATION_MAIN_ID);
        appBarPage.getNavigationMain().check(matches(isDisplayed()));
        appBarPage.getNavigationMain().perform(appBarPage.click());
    }

    @Step("Нажатие кнопки 'Love is All'")
    public void clickLoveIsAllBtn() {
        WaitId.waitUntilElement(appBarPage.LOVE_IS_ALL_BTN_ID);
        appBarPage.getLoveIsAllBtn().check(matches(isDisplayed()));
        appBarPage.getLoveIsAllBtn().perform(appBarPage.click());
    }

    @Step("Проверка заголовка 'Love is All'")
    public void checkLoveIsAllTitle() {
        WaitId.waitUntilElement(loveIsAllPage.LOVE_IS_ALL_TITLE_ID);
        loveIsAllPage.getLoveIsAllTitle().check(matches(isDisplayed()));
        loveIsAllPage.getLoveIsAllTitle().check(matches(withText(loveTitle)));
    }

    @Step("Проверка заголовка страницы 'News'")
    public void checkNewsPageTitle() {
        WaitId.waitUntilElement(newsPage.NEWS_PAGE_TITLE_ID);
        newsPage.newsPageTitle().check(matches(isDisplayed()));
        newsPage.newsPageTitle().check(matches(withText(newsPageTitle)));
    }

    @Step("Проверка отображения заголовка новости")
    public void checkNewsTitle() {
        WaitId.waitUntilElement(newsPage.NEWS_PAGE_TITLE_ID);
        newsPage.newsPageTitle().check(matches(isDisplayed()));
    }

    @Step("Выход из приложения")
    public void exit() {
        WaitId.waitUntilElement(appBarPage.EXIT_BUTTON_ID);
        appBarPage.getExitButton().check(matches(isDisplayed()));
        appBarPage.getExitButton().perform(appBarPage.click());

        WaitId.waitUntilElement(appBarPage.LOGOUT_TEXT_ID);
        appBarPage.getLogOutText().check(matches(isDisplayed()));
        appBarPage.getLogOutText().perform(appBarPage.click());
    }
}
