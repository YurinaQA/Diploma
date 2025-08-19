package ru.iteco.fmhandroid.ui.pages;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import androidx.test.espresso.ViewInteraction;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.RecyclerViewMatcher;

public class LoveIsAllPage {

    // ID элементов
    public final int LIST_RECYCLER_VIEW_ID = R.id.our_mission_item_list_recycler_view;
    public final int CARD_VIEW_ID = R.id.our_mission_item_material_card_view;
    public final int DESCRIPTION_TEXT_ID = R.id.our_mission_item_description_text_view;
    public final int TITLE_TEXT_ID = R.id.our_mission_title_text_view;

    /** Получение карточки по позиции */
    public ViewInteraction getCardAt(int position) {
        return onView(new RecyclerViewMatcher(LIST_RECYCLER_VIEW_ID)
                .atPositionOnView(position, CARD_VIEW_ID));
    }

    /** Получение описания по позиции */
    public ViewInteraction getDescriptionTextAt(int position) {
        return onView(new RecyclerViewMatcher(LIST_RECYCLER_VIEW_ID)
                .atPositionOnView(position, DESCRIPTION_TEXT_ID));
    }

    /** Клик по цитате в позиции */
    public void clickOnQuote(int position) {
        getCardAt(position).perform(click());
    }

    /** Заголовок страницы "Love is all" */
    public ViewInteraction getLoveIsAllTitle() {
        return onView(withId(TITLE_TEXT_ID));
    }
}
