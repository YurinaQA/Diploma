package ru.iteco.fmhandroid.ui.pages;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;

public class MainPage {

    // Публичные ID и тексты для Step
    public final int EXPAND_NEWS_BUTTON_ID = R.id.expand_material_button;
    public final int ALL_NEWS_TEXT_VIEW_ID = R.id.all_news_text_view;
    public final String ALL_NEWS_TEXT = "ALL NEWS";
    public final int NEWS_FEED_CONTAINER_ID = R.id.container_list_news_include_on_fragment_main;

    /** Кнопка для сворачивания/разворачивания ленты новостей */
    public ViewInteraction getOpenNewsButton() {
        return onView(withId(EXPAND_NEWS_BUTTON_ID));
    }

    /** Текст "ALL NEWS" для проверки отображения на главной странице */
    public ViewInteraction getAllNewsText() {
        return onView(allOf(withId(ALL_NEWS_TEXT_VIEW_ID), withText(ALL_NEWS_TEXT)));
    }

    /** Кнопка "ALL NEWS" для перехода на страницу новостей */
    public ViewInteraction getAllNewsButton() {
        return onView(allOf(withId(ALL_NEWS_TEXT_VIEW_ID), withText(ALL_NEWS_TEXT)));
    }

    /** Заголовок новостной ленты на главной странице */
    public ViewInteraction getNewsFeedTitle() {
        return onView(withId(NEWS_FEED_CONTAINER_ID));
    }
}
