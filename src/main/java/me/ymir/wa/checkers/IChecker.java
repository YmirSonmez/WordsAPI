package me.ymir.wa.checkers;

import java.util.Locale;

public interface IChecker {
    boolean isWord(String word);
    Locale getLocale();
}
