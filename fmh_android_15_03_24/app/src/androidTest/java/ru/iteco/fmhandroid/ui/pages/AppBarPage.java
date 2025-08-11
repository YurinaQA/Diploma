package ru.iteco.fmhandroid.ui.pages;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;

public class AppBarPage {


    private final int NAVIGATION_BUTTON_ID = R.id.main_menu_image_button;
    private final int OUR_MISSION_BUTTON_ID = R.id.our_mission_image_button;
    private final int EXIT_BUTTON_ID = R.id.authorization_image_button;

    private final String OUR_MISSION_DESCRIPTION = "Our Mission";

    private final int NAV_MENU_TITLE_ID = android.R.id.title;
    private final String NEWS_TEXT = "News";
    private final String ABOUT_TEXT = "About";
    private final String MAIN_TEXT = "Main";
    private final String LOGOUT_TEXT = "Log out";


    /** Кнопка открытия навигационного меню ("бургер") */
    public ViewInteraction getNavigationButton() {
        return onView(withId(NAVIGATION_BUTTON_ID));
    }

    /** Пункт меню "News" */
    public ViewInteraction getNavigationNews() {
        return onView(allOf(withId(NAV_MENU_TITLE_ID), withText(NEWS_TEXT)));
    }

    /** Пункт меню "About" */
    public ViewInteraction getNavigationAbout() {
        return onView(allOf(withId(NAV_MENU_TITLE_ID), withText(ABOUT_TEXT)));
    }

    /** Пункт меню "Main" */
    public ViewInteraction getNavigationMain() {
        return onView(allOf(withId(NAV_MENU_TITLE_ID), withText(MAIN_TEXT)));
    }

    /** Кнопка "Our Mission" (иконка бабочки) */
    public ViewInteraction getLoveIsAllBtn() {
        return onView(allOf(withId(OUR_MISSION_BUTTON_ID), withContentDescription(OUR_MISSION_DESCRIPTION)));
    }

    /** Кнопка выхода (иконка человечка) */
    public ViewInteraction getExitButton() {
        return onView(withId(EXIT_BUTTON_ID));
    }

    /** Пункт меню "Log out" */
    public ViewInteraction getLogOutText() {
        return onView(allOf(withId(NAV_MENU_TITLE_ID), withText(LOGOUT_TEXT)));
    }
}
