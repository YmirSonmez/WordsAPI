package me.ymir.wa;

import me.ymir.wa.checkers.CheckerManager;
import me.ymir.wa.checkers.IChecker;
import me.ymir.wa.games.wordgame.WordGame;

public class WordsAPI {
    public static CheckerManager getCheckManager(){
        return new CheckerManager();
    }

    public static WordGame getNewWordGame(){
        return getNewWordGame(CheckerManager.getInstance().getChecker("tr_TR"));
    }

    public static WordGame getNewWordGame(int countDown){
        return getNewWordGame(CheckerManager.getInstance().getChecker("tr_TR"),countDown);
    }

    public static WordGame getNewWordGame(IChecker checker){
        return getNewWordGame(checker,30);
    }

    public static WordGame getNewWordGame(IChecker checker, int countDown){
        return new WordGame(checker,countDown);
    }
}
