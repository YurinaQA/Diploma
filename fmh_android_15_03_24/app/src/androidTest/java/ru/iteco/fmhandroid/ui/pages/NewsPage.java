package ru.iteco.fmhandroid.ui.pages;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

import androidx.test.espresso.ViewInteraction;
import androidx.test.espresso.matcher.RootMatchers;
import androidx.test.espresso.action.ViewActions;

import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.RecyclerViewMatcher;

public class NewsPage {


    private final int ALL_NEWS_TEXT_VIEW_ID = R.id.all_news_text_view;
    private final String ALL_NEWS_TEXT = "ALL NEWS";
    private final int REFRESH_BUTTON_ID = R.id.news_list_swipe_refresh;
    private final int CONTROL_PANEL_BUTTON_ID = R.id.edit_news_material_button;
    private final int ADD_NEWS_BUTTON_ID = R.id.add_news_image_view;

    public ViewInteraction newsPageTitle() {
        return onView(allOf(withId(ALL_NEWS_TEXT_VIEW_ID), withText(ALL_NEWS_TEXT)));
    }

    public ViewInteraction refreshBtn() {
        return onView(withId(REFRESH_BUTTON_ID));
    }

    public ViewInteraction controlPanelBtn() {
        return onView(withId(CONTROL_PANEL_BUTTON_ID));
    }

    public ViewInteraction addNewsBtn() {
        return onView(withId(ADD_NEWS_BUTTON_ID));
    }


    //  Список новостей

    private final int NEWS_LIST_ID = R.id.news_list_recycler_view;
    private final int NEWS_CARD_ID = R.id.news_item_material_card_view;
    private final int NEWS_TITLE_ID = R.id.news_item_title_text_view;

    public ViewInteraction newsList() {
        return onView(withId(NEWS_LIST_ID));
    }

    public ViewInteraction newsItemWithTitle(String title) {
        return onView(allOf(withId(NEWS_TITLE_ID), withText(title)));
    }

    public ViewInteraction newsCardAt(int position) {
        return onView(new RecyclerViewMatcher(NEWS_LIST_ID).atPositionOnView(position, NEWS_CARD_ID));
    }

    public ViewInteraction editNewsBtnAt(int position) {
        return onView(new RecyclerViewMatcher(NEWS_LIST_ID)
                .atPositionOnView(position, R.id.edit_news_item_image_view));
    }


    //  Форма создания/редактирования новости

    private final int NEWS_TITLE_INPUT_ID = R.id.news_item_title_text_input_edit_text;
    private final int NEWS_CATEGORY_INPUT_ID = R.id.news_item_category_text_auto_complete_text_view;
    private final int NEWS_DATE_INPUT_ID = R.id.news_item_publish_date_text_input_edit_text;
    private final int NEWS_TIME_INPUT_ID = R.id.news_item_publish_time_text_input_edit_text;
    private final int NEWS_DESCRIPTION_INPUT_ID = R.id.news_item_description_text_input_edit_text;

    public ViewInteraction newsTitleInput() {
        return onView(withId(NEWS_TITLE_INPUT_ID));
    }

    public ViewInteraction newsCategoryInput() {
        return onView(withId(NEWS_CATEGORY_INPUT_ID));
    }

    public ViewInteraction newsDateInput() {
        return onView(withId(NEWS_DATE_INPUT_ID));
    }

    public ViewInteraction newsTimeInput() {
        return onView(withId(NEWS_TIME_INPUT_ID));
    }

    public ViewInteraction newsDescriptionInput() {
        return onView(withId(NEWS_DESCRIPTION_INPUT_ID));
    }

    /**
     * Выбор категории из выпадающего списка
     */
    public void selectCategoryFromList(String category) {
        onView(withText(category))
                .inRoot(RootMatchers.isPlatformPopup())
                .perform(ViewActions.click());
    }


    private final int SAVE_BUTTON_ID = R.id.save_button;
    private final int CANCEL_BUTTON_ID = R.id.cancel_button;
    private final int MESSAGE_ID = android.R.id.message;
    private final int OK_MESSAGE_BUTTON_ID = android.R.id.button1;

    public ViewInteraction saveNewsBtn() {
        return onView(withId(SAVE_BUTTON_ID));
    }

    public ViewInteraction cancelNewsBtn() {
        return onView(withId(CANCEL_BUTTON_ID));
    }

    public ViewInteraction message() {
        return onView(withId(MESSAGE_ID));
    }

    public ViewInteraction okMessage() {
        return onView(withId(OK_MESSAGE_BUTTON_ID));
    }
}
