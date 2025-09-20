package ru.iteco.fmhandroid.ui.utils;

import io.qameta.allure.kotlin.Allure;

public class AllureStep {
    public static void step(String name, Runnable action) {
        Allure.step(name, stepContext -> {
            action.run();
            return null;
        });
    }
}
