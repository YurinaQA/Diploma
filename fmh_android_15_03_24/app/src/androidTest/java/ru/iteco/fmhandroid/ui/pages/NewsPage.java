package ru.iteco.fmhandroid.ui.pages;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

import androidx.test.espresso.ViewInteraction;
import androidx.test.espresso.matcher.RootMatchers;
import androidx.test.espresso.action.ViewActions;

import ru.iteco.fmhandroid.R;

public class NewsPage {

    // ===== Локаторы =====
    private final int ALL_NEWS_TEXT_VIEW_ID = R.id.all_news_text_view;
    private final String ALL_NEWS_TEXT = "ALL NEWS";
    private final int REFRESH_BUTTON_ID = R.id.news_list_swipe_refresh;
    private final int NEWS_LIST_ID = R.id.news_list_recycler_view;
    private final int NEWS_CARD_ID = R.id.news_item_material_card_view;
    private final int NEWS_TITLE_ID = R.id.news_item_title_text_view;
    private final int DELETE_NEWS_BUTTON_ID = R.id.delete_news_item_image_view;
    private final String DELETE_CONFIRM_TEXT = "Are you sure you want to permanently delete the document?";
    private final int DIALOG_OK_BUTTON_ID = android.R.id.button1;
    private final int FILTER_NEWS_BUTTON_ID = R.id.filter_news_material_button;
    private final String FILTER_NEWS_TEXT = "Filter news";
    private final int CATEGORY_LIST_INPUT_LAYOUT_ID = R.id.news_item_category_text_input_layout;
    private final int FILTER_BUTTON_ID = R.id.filter_button;
    private final int CANCEL_FILTER_BUTTON_ID = R.id.cancel_button;
    private final String NO_NEWS_TEXT = "There is nothing here yet…";
    private final int CONTROL_PANEL_BUTTON_ID = R.id.edit_news_material_button;
    private final String CONTROL_PANEL_TEXT = "Control panel";
    private final int EDIT_NEWS_BUTTON_ID = R.id.edit_news_item_image_view;
    private final String EDITING_TEXT = "Editing";
    private final int ADD_NEWS_BUTTON_ID = R.id.add_news_image_view;
    private final String CREATING_TEXT = "Creating";
    private final int SAVE_BUTTON_ID = R.id.save_button;
    private final int CANCEL_BUTTON_ID = R.id.cancel_button;
    private final int MESSAGE_ID = android.R.id.message;
    private final int OK_MESSAGE_BUTTON_ID = android.R.id.button1;
    private final int NEWS_CATEGORY_TEXT_VIEW_ID = R.id.news_item_category_text_view;
    private final int NEWS_DESCRIPTION_TEXT_VIEW_ID = R.id.news_item_description_text_view;
    private final int NEWS_DATE_TEXT_VIEW_ID = R.id.news_item_date_text_view;
    private final int EXPAND_NEWS_BUTTON_ID = R.id.view_news_item_image_view;
    private final int NEWS_CATEGORY_ICON_ID = R.id.category_icon_image_view;
    private final int CUSTOM_CATEGORY_INPUT_ID = R.id.news_item_category_text_auto_complete_text_view;


    public ViewInteraction newsPageTitle() {
        return onView(allOf(withId(ALL_NEWS_TEXT_VIEW_ID), withText(ALL_NEWS_TEXT)));
    }

    public ViewInteraction refreshBtn() {
        return onView(withId(REFRESH_BUTTON_ID));
    }

    public ViewInteraction newsList() {
        return onView(withId(NEWS_LIST_ID));
    }

    public ViewInteraction newsBox() {
        return onView(withId(NEWS_CARD_ID));
    }

    public ViewInteraction newCPTitleNews() {
        return onView(withId(NEWS_TITLE_ID));
    }

    public ViewInteraction cpDeleteBtn() {
        return onView(withId(DELETE_NEWS_BUTTON_ID));
    }

    public ViewInteraction cpDialogWindow() {
        return onView(withText(DELETE_CONFIRM_TEXT));
    }

    public ViewInteraction cpDialogWinOKBtn() {
        return onView(withId(DIALOG_OK_BUTTON_ID));
    }

    public ViewInteraction filterNewsSection() {
        return onView(withId(FILTER_NEWS_BUTTON_ID));
    }

    public ViewInteraction filterNewsSectionTitle() {
        return onView(withText(FILTER_NEWS_TEXT));
    }

    public ViewInteraction openCategoryList() {
        return onView(withId(CATEGORY_LIST_INPUT_LAYOUT_ID));
    }

    public ViewInteraction filterBtn() {
        return onView(withId(FILTER_BUTTON_ID));
    }

    public ViewInteraction cancelBtnFilter() {
        return onView(withId(CANCEL_FILTER_BUTTON_ID));
    }

    public ViewInteraction notNewsYet() {
        return onView(withText(NO_NEWS_TEXT));
    }

    public ViewInteraction controlPanel() {
        return onView(withId(CONTROL_PANEL_BUTTON_ID));
    }

    public ViewInteraction controlPanelTitle() {
        return onView(withText(CONTROL_PANEL_TEXT));
    }

    public ViewInteraction editingBtn() {
        return onView(withId(EDIT_NEWS_BUTTON_ID));
    }

    public ViewInteraction editingSectionTitle() {
        return onView(withText(EDITING_TEXT));
    }

    public ViewInteraction creatingNewsBtn() {
        return onView(withId(ADD_NEWS_BUTTON_ID));
    }

    public ViewInteraction creatingNewsTitle() {
        return onView(withText(CREATING_TEXT));
    }

    public ViewInteraction enSaveBtn() {
        return onView(withId(SAVE_BUTTON_ID));
    }

    public ViewInteraction enCancelBtn() {
        return onView(withId(CANCEL_BUTTON_ID));
    }

    public ViewInteraction message() {
        return onView(withId(MESSAGE_ID));
    }

    public ViewInteraction okMessage() {
        return onView(withId(OK_MESSAGE_BUTTON_ID));
    }

    public ViewInteraction newsCategory() {
        return onView(withId(NEWS_CATEGORY_TEXT_VIEW_ID));
    }

    public ViewInteraction newsDescription() {
        return onView(withId(NEWS_DESCRIPTION_TEXT_VIEW_ID));
    }

    public ViewInteraction newsDate() {
        return onView(withId(NEWS_DATE_TEXT_VIEW_ID));
    }

    public ViewInteraction expandNewsBtn() {
        return onView(withId(EXPAND_NEWS_BUTTON_ID));
    }

    public ViewInteraction newsCategoryIcon() {
        return onView(withId(NEWS_CATEGORY_ICON_ID));
    }

    public ViewInteraction customCategoryInput() {
        return onView(withId(CUSTOM_CATEGORY_INPUT_ID));
    }

    public ViewInteraction filteredNewsList() {
        return onView(withId(NEWS_LIST_ID));
    }

    // Выбор категории из выпадающего списка
    public void selectCategoryFromList(String category) {
        onView(withText(category))
                .inRoot(RootMatchers.isPlatformPopup())
                .perform(ViewActions.click());
    }
}
