package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.action.ViewActions.clearText;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import io.qameta.allure.kotlin.Step;
import ru.iteco.fmhandroid.ui.pages.NewsPage;

public class NewsStep {

    private final NewsPage newsPage = new NewsPage();

    // ===== Проверки =====
    @Step("Проверить, что заголовок страницы новостей отображается")
    public void checkNewsPageTitleDisplayed() {
        newsPage.newsPageTitle().check(matches(isDisplayed()));
    }

    @Step("Проверить, что сообщение о пустой ленте новостей отображается")
    public void checkNoNewsMessageDisplayed() {
        newsPage.notNewsYet().check(matches(isDisplayed()));
    }

    @Step("Проверить, что новость с заголовком '{title}' отображается")
    public void checkNewsDisplayed(String title) {
        newsPage.newsItemWithTitle(title).check(matches(isDisplayed()));
    }

    @Step("Проверить, что новость с заголовком '{title}' успешно создана")
    public void checkNewsCreated(String title) {
        newsPage.newsItemWithTitle(title).check(matches(isDisplayed()));
    }

    @Step("Проверить, что новость обновлена. Новый заголовок: '{updatedTitle}'")
    public void checkNewsUpdated(String updatedTitle) {
        newsPage.newsItemWithTitle(updatedTitle).check(matches(isDisplayed()));
    }

    @Step("Проверить, что новость с заголовком '{title}' удалена (не отображается)")
    public void checkNewsDeleted(String title) {
        try {
            newsPage.newsItemWithTitle(title).check(matches(isDisplayed()));
            throw new AssertionError("Новость с заголовком '" + title + "' все еще отображается!");
        } catch (Exception ignored) {
            // Ожидаемое поведение — элемент не найден
        }
    }

    // ===== Действия =====
    @Step("Нажать на кнопку обновления новостей")
    public void clickRefreshButton() {
        newsPage.refreshBtn().perform(click());
    }

    @Step("Открыть секцию фильтров новостей")
    public void openFilterNewsSection() {
        newsPage.filterNewsSection().perform(click());
        newsPage.filterNewsSectionTitle().check(matches(isDisplayed()));
    }

    @Step("Выбрать категорию новости: {category}")
    public void selectCategory(String category) {
        newsPage.openCategoryList().perform(click());
        newsPage.selectCategoryFromList(category);
    }

    @Step("Нажать кнопку фильтрации новостей")
    public void clickFilterButton() {
        newsPage.filterBtn().perform(click());
    }

    @Step("Нажать кнопку отмены фильтра")
    public void clickCancelFilterButton() {
        newsPage.cancelBtnFilter().perform(click());
    }

    @Step("Ввести кастомную категорию: {text}")
    public void typeCustomCategory(String text) {
        newsPage.customCategoryInput().perform(typeText(text));
    }

    @Step("Открыть панель управления новостями")
    public void openControlPanel() {
        newsPage.controlPanelBtn().perform(click());
    }

    @Step("Нажать кнопку добавления новости")
    public void clickAddNewsButton() {
        newsPage.addNewsBtn().perform(click());
    }

    @Step("Ввести заголовок новости: {title}")
    public void enterNewsTitle(String title) {
        newsPage.newsTitleInput().perform(replaceText(title));
    }

    @Step("Очистить поле заголовка новости")
    public void clearNewsTitle() {
        newsPage.newsTitleInput().perform(clearText());
    }

    @Step("Выбрать категорию новости: {category}")
    public void selectNewsCategory(String category) {
        newsPage.newsCategoryInput().perform(click());
        newsPage.selectCategoryFromList(category);
    }

    @Step("Ввести дату публикации новости: {date}")
    public void enterNewsDate(String date) {
        newsPage.newsDateInput().perform(replaceText(date));
    }

    @Step("Ввести время публикации новости: {time}")
    public void enterNewsTime(String time) {
        newsPage.newsTimeInput().perform(replaceText(time));
    }

    @Step("Ввести описание новости: {description}")
    public void enterNewsDescription(String description) {
        newsPage.newsDescriptionInput().perform(replaceText(description));
    }

    @Step("Сохранить новость")
    public void clickSaveNewsButton() {
        newsPage.saveNewsBtn().perform(click());
    }

    @Step("Редактировать новость на позиции: {position}")
    public void clickEditNewsAtPosition(int position) {
        newsPage.editNewsBtnAt(position).perform(click());
    }

    @Step("Удалить новость на позиции: {position}")
    public void clickDeleteNewsAtPosition(int position) {
        newsPage.deleteNewsBtnAt(position).perform(click());
    }

    // ===== Новые проверки, чтобы заменить старые несуществующие методы =====
    @Step("Проверить, что создается новость (для панели добавления)")
    public void checkCreatingNewsTitleDisplayed() {
        newsPage.newsTitleInput().check(matches(isDisplayed()));
    }

    @Step("Проверить, что редактируется новость (для панели редактирования)")
    public void checkEditingNewsTitleDisplayed() {
        newsPage.newsTitleInput().check(matches(isDisplayed()));
    }
}
