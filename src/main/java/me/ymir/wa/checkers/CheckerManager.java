package me.ymir.wa.checkers;

import me.ymir.wa.exceptions.AlreadyRegisteredException;

import java.util.HashMap;

public class CheckerManager {
    private static final String[] SUPPORTED_DEFAULT_LANGUAGES = new String[]{"tr_TR"};

    private HashMap<String, IChecker> checkers;

    public CheckerManager() {

        checkers = new HashMap<>();

    }

    public static CheckerManager getInstance(){
        return new CheckerManager().init();
    }

    public CheckerManager init(){
        try {
            register(new TurkishChecker(),"tr_TR");
        } catch (AlreadyRegisteredException ignored) {
        }
        return this;
    }

    public void register(IChecker checker, String languageKey) throws AlreadyRegisteredException {
        if(checkers.containsKey(languageKey)){
            throw new AlreadyRegisteredException(languageKey+" already registered on manager.");
        }else{
            checkers.put(languageKey,checker);
        }
    }

    public boolean unRegister(String languageKey){
        if(!checkers.containsKey(languageKey)){
            return false;
        }
        checkers.remove(languageKey);
        return true;
    }

    public String[] getRegisteredLanguages(){
        String[] languages = new String[checkers.size()];
        final int[] i = {0};
        checkers.keySet().forEach(v -> languages[i[0]++] = v);
        return languages;
    }

    public IChecker getChecker(String languageKey){
        return checkers.get(languageKey);
    }

}
