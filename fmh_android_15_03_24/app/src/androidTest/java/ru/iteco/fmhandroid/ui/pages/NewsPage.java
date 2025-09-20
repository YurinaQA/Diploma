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

    // -------- Заголовки и основные элементы --------
    private final int ALL_NEWS_TEXT_VIEW_ID = R.id.all_news_text_view;
    private final String ALL_NEWS_TEXT = "ALL NEWS";
    private final int REFRESH_BUTTON_ID = R.id.news_list_swipe_refresh;
    private final int CONTROL_PANEL_BUTTON_ID = R.id.edit_news_material_button;
    private final int ADD_NEWS_BUTTON_ID = R.id.add_news_image_view;

    /** Возвращает ViewInteraction заголовка страницы "News" */
    public ViewInteraction newsPageTitle() {
        return onView(allOf(withId(ALL_NEWS_TEXT_VIEW_ID), withText(ALL_NEWS_TEXT)));
    }

    /** Публичный метод для получения ID заголовка (для WaitId) */
    public int getAllNewsTextViewId() {
        return ALL_NEWS_TEXT_VIEW_ID;
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

    // -------- Список новостей --------
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

    public ViewInteraction deleteNewsBtnAt(int position) {
        return onView(new RecyclerViewMatcher(NEWS_LIST_ID)
                .atPositionOnView(position, R.id.delete_news_item_image_view));
    }

    public ViewInteraction filteredNewsList() {
        return onView(withId(NEWS_LIST_ID));
    }

    // -------- Сообщение "нет новостей" --------
    private final int NOT_NEWS_YET_ID = R.id.empty_news_list_text_view;
    private final String NOT_NEWS_YET_TEXT = "There is nothing here yet...";

    public ViewInteraction notNewsYet() {
        return onView(allOf(withId(NOT_NEWS_YET_ID), withText(NOT_NEWS_YET_TEXT)));
    }

    // -------- Форма создания/редактирования новости --------
    private final int NEWS_TITLE_INPUT_ID = R.id.news_item_title_text_input_edit_text;
    private final int NEWS_CATEGORY_INPUT_ID = R.id.news_item_category_text_auto_complete_text_view;
    private final int NEWS_DATE_INPUT_ID = R.id.news_item_publish_date_text_input_edit_text;
    private final int NEWS_TIME_INPUT_ID = R.id.news_item_publish_time_text_input_edit_text;
    private final int NEWS_DESCRIPTION_INPUT_ID = R.id.news_item_description_text_input_edit_text;

    private final int CREATING_NEWS_TITLE_ID = R.id.custom_app_bar_title_text_view;
    private final String CREATING_NEWS_TITLE_TEXT = "Creating";

    private final int EDITING_NEWS_TITLE_ID = R.id.custom_app_bar_title_text_view;
    private final String EDITING_NEWS_TITLE_TEXT = "Editing";

    public ViewInteraction newsTitleInput() {
        return onView(withId(NEWS_TITLE_INPUT_ID));
    }

    public ViewInteraction newsCategoryInput() {
        return onView(withId(NEWS_CATEGORY_INPUT_ID));
    }

    /** Метод для открытия списка категорий */
    public ViewInteraction openCategoryList() {
        return newsCategoryInput();
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

    public ViewInteraction creatingNewsTitle() {
        return onView(allOf(withId(CREATING_NEWS_TITLE_ID), withText(CREATING_NEWS_TITLE_TEXT)));
    }

    public ViewInteraction editingNewsTitle() {
        return onView(allOf(withId(EDITING_NEWS_TITLE_ID), withText(EDITING_NEWS_TITLE_TEXT)));
    }

    public void selectCategoryFromList(String category) {
        onView(withText(category))
                .inRoot(RootMatchers.isPlatformPopup())
                .perform(ViewActions.click());
    }

    // -------- Кнопки сохранения/отмены --------
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

    // -------- Фильтрация новостей --------
    private final int FILTER_NEWS_SECTION_ID = R.id.filter_news_material_button;
    private final int FILTER_NEWS_TITLE_ID = R.id.filter_news_title_text_view;
    private final int CUSTOM_CATEGORY_INPUT_ID = R.id.news_item_category_text_auto_complete_text_view;
    private final int FILTER_BUTTON_ID = R.id.filter_button;
    private final int CANCEL_FILTER_BUTTON_ID = R.id.cancel_button;

    public ViewInteraction filterNewsSection() {
        return onView(withId(FILTER_NEWS_SECTION_ID));
    }

    public ViewInteraction filterNewsSectionTitle() {
        return onView(withId(FILTER_NEWS_TITLE_ID));
    }

    public ViewInteraction customCategoryInput() {
        return onView(withId(CUSTOM_CATEGORY_INPUT_ID));
    }

    public ViewInteraction filterBtn() {
        return onView(withId(FILTER_BUTTON_ID));
    }

    public ViewInteraction cancelBtnFilter() {
        return onView(withId(CANCEL_FILTER_BUTTON_ID));
    }
}
