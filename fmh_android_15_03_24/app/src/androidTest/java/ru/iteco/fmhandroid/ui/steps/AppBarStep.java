package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import ru.iteco.fmhandroid.ui.pages.AppBarPage;
import ru.iteco.fmhandroid.ui.pages.LoveIsAllPage;
import ru.iteco.fmhandroid.ui.pages.NewsPage;

public class AppBarStep {

    private final AppBarPage appBarPage = new AppBarPage();
    private final NewsPage newsPage = new NewsPage();
    private final LoveIsAllPage loveIsAllPage = new LoveIsAllPage();

    /** Нажатие на кнопку "бургер" */
    public void clickNavigationBtn() {
        appBarPage.getNavigationButton().perform(click());
    }

    /** Нажатие на пункт меню "News" */
    public void clickNavigationNews() {
        appBarPage.getNavigationNews().perform(click());
    }

    /** Нажатие на пункт меню "About" */
    public void clickNavigationAbout() {
        appBarPage.getNavigationAbout().perform(click());
    }

    /** Нажатие на пункт меню "Main" */
    public void clickNavigationMain() {
        appBarPage.getNavigationMain().perform(click());
    }

    /** Нажатие на кнопку "Our Mission" */
    public void clickLoveIsAllBtn() {
        appBarPage.getLoveIsAllBtn().perform(click());
    }

    /** Нажатие на кнопку выхода */
    public void exit() {
        appBarPage.getExitButton().perform(click());
    }

    /** Нажатие на пункт "Log out" */
    public void clickLogOut() {
        appBarPage.getLogOutText().perform(click());
    }

    /** Проверка заголовка страницы Новости с конкретным текстом */
    public void checkNewsPageTitle(String expectedTitle) {
        newsPage.newsPageTitle().check(matches(withText(expectedTitle)));
    }

    /** Перегрузка для совместимости без аргумента */
    public void checkNewsPageTitle() {
        checkNewsPageTitle("ALL NEWS");
    }

    /** Проверка заголовка главной страницы */
    public void checkMainPage() {
        appBarPage.getMainPageTitle().check(matches(isDisplayed()));
    }

    /** Проверка заголовка страницы Love is All */
    public void checkLoveIsAllTitle() {
        loveIsAllPage.getLoveIsAllTitle().check(matches(isDisplayed()));
    }
}
