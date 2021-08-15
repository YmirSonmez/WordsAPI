package me.ymir.wa.games.wordgame;

import me.ymir.wa.WordsAPI;
import me.ymir.wa.checkers.CheckerManager;
import me.ymir.wa.checkers.IChecker;

import java.util.*;

public class WordGame {
    private Long room;
    private IChecker checker;
    private ArrayList<String> used;
    private HashMap<String,Integer> scores;

    private boolean start = false;
    private boolean finished = false;

    private int countDown;

    private String last = "";
    private String lastPlayer = "";
    private int remaining;

    public WordGame(IChecker checker, int countDown) {
        this.checker = checker;
        this.countDown = countDown;
        this.scores = new HashMap<>();
        this.used = new ArrayList<>();
        this.remaining = countDown;
        this.room = new Random().nextLong();
    }

    public WordGame start(){
        start = true;
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                remaining--;
                if(remaining <=0){
                    finish();
                    this.cancel();
                }
            }
        }, 0, 1000);
        return this;
    }

    public WordGameCheckOut input(String player, String word){
        if(!start || finished) return WordGameCheckOut.ERROR;
        if(!word.matches("[a-zA-Z]*")) return WordGameCheckOut.ERROR;
        if(lastPlayer.equalsIgnoreCase(player)) return WordGameCheckOut.DOUBLE_WRITE;
        if(!checker.isWord(word)) return WordGameCheckOut.NOT_WORD;
        if(used.contains(word.toLowerCase(checker.getLocale()))) return WordGameCheckOut.USED;
        if(!last.equalsIgnoreCase("") && !String.valueOf(word.charAt(0)).equalsIgnoreCase(String.valueOf(last.charAt(last.length()-1)))) return WordGameCheckOut.NOT_MATCH;
        last = word;
        lastPlayer = player;
        upPlayerScore(player);
        used.add(word.toLowerCase(checker.getLocale()));
        remaining = countDown;
        return WordGameCheckOut.SUCCESS;
    }

    private void upPlayerScore(String player){
        if(scores.containsKey(player)){
            scores.put(player,scores.get(player)+1);
        }else{
            scores.put(player,1);
        }
    }


    public void finish(){
        finished = true;
        WordGameResults results = new WordGameResults();
        results.setRoom(room);
        results.setLastWord(last.equalsIgnoreCase("") ? null : last);
        results.setLastPlayer(lastPlayer.equalsIgnoreCase("") ? null : lastPlayer);
        results.setScores(scores);
        results.setUsed(used);
        System.out.println(room+" finished...");
        if(WordsAPI.specialFinish.containsKey(room)){
            WordsAPI.specialFinish.remove(room).handle(results);
        }
    }

    public Long getRoom() {
        return room;
    }

    public String getLast() {
        return String.valueOf(last.charAt(last.length()-1));
    }


}
