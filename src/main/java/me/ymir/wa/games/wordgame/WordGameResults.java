package me.ymir.wa.games.wordgame;

import java.util.ArrayList;
import java.util.HashMap;

public class WordGameResults {
    private HashMap<String, Integer> scores;
    private ArrayList<String> used;
    private String lastWord;
    private String lastPlayer;
    private Long room;

    public WordGameResults(){
        this(null,null,null,null,null);
    }

    public WordGameResults(HashMap<String, Integer> scores, ArrayList<String> used, String lastWord, String lastPlayer,Long room) {
        this.scores = scores;
        this.used = used;
        this.lastWord = lastWord;
        this.lastPlayer = lastPlayer;
        this.room = room;
    }

    public HashMap<String, Integer> getScores() {
        return scores;
    }

    public void setScores(HashMap<String, Integer> scores) {
        this.scores = scores;
    }

    public ArrayList<String> getUsed() {
        return used;
    }

    public void setUsed(ArrayList<String> used) {
        this.used = used;
    }

    public String getLastWord() {
        return lastWord;
    }

    public void setLastWord(String lastWord) {
        this.lastWord = lastWord;
    }

    public String getLastPlayer() {
        return lastPlayer;
    }

    public void setLastPlayer(String lastPlayer) {
        this.lastPlayer = lastPlayer;
    }

    public Long getRoom() {
        return room;
    }

    public void setRoom(Long room) {
        this.room = room;
    }
}
