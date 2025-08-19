package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static org.hamcrest.Matchers.not;

import io.qameta.allure.kotlin.Step;
import ru.iteco.fmhandroid.ui.WaitId;
import ru.iteco.fmhandroid.ui.pages.LoveIsAllPage;

public class LoveIsAllStep {

    private final LoveIsAllPage loveIsAllPage = new LoveIsAllPage();

    @Step("Клик по цитате на позиции {num}")
    public void clickOnQuote(int num) {
        WaitId.waitUntilElement(loveIsAllPage.LIST_RECYCLER_VIEW_ID);
        loveIsAllPage.clickOnQuote(num);
    }

    @Step("Проверка, что описание цитаты на позиции {num} отображается")
    public void checkDescriptionIsDisplayed(int num) {
        WaitId.waitUntilElement(loveIsAllPage.DESCRIPTION_TEXT_ID);
        loveIsAllPage.getDescriptionTextAt(num).check(matches(isDisplayed()));
    }

    @Step("Проверка, что описание цитаты на позиции {num} не отображается")
    public void checkDescriptionIsNotDisplayed(int num) {
        WaitId.waitUntilElement(loveIsAllPage.DESCRIPTION_TEXT_ID);
        loveIsAllPage.getDescriptionTextAt(num).check(matches(not(isDisplayed())));
    }

    @Step("Проверка отображения заголовка страницы Love Is All")
    public void checkTitleIsDisplayed() {
        WaitId.waitUntilElement(loveIsAllPage.TITLE_TEXT_ID);
        loveIsAllPage.getLoveIsAllTitle().check(matches(isDisplayed()));
    }
}
