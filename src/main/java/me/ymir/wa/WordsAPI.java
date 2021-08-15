package me.ymir.wa;

import me.ymir.wa.checkers.CheckerManager;
import me.ymir.wa.checkers.IChecker;
import me.ymir.wa.games.wordgame.WordGame;
import me.ymir.wa.games.wordgame.WordGameFinish;
import me.ymir.wa.games.wordgame.WordGameResults;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;

public class WordsAPI {
    public static HashMap<Long, WordGameFinish> specialFinish = new HashMap<>();

    public static CheckerManager getCheckManager() {
        return new CheckerManager();
    }

    public static WordGame getNewWordGame() {
        return getNewWordGame(CheckerManager.getInstance().getChecker("tr_TR"));
    }

    public static WordGame getNewWordGame(int countDown) {
        return getNewWordGame(CheckerManager.getInstance().getChecker("tr_TR"), countDown);
    }

    public static WordGame getNewWordGame(IChecker checker) {
        return getNewWordGame(checker, 30);
    }

    public static WordGame getNewWordGame(IChecker checker, int countDown) {
        return new WordGame(checker, countDown);
    }

    public static WordGame getNewWordGame(IChecker checker, int countDown, WordGameFinish finish) {
        WordGame game = new WordGame(checker, countDown);
        specialFinish.put(game.getRoom(), finish);
        return game;
    }


}
