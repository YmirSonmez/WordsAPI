# WordsAPI
Simple Word Games API

### Supported Languages
- Turkish

### Create Own Language Support
You can pull request
```JAVA
public class YourChecker implements IChecker {
    @Override
    public boolean isWord(String word) {
        return true;
    }

    @Override
    public Locale getLocale() {
        return Locale;
    }
```
```JAVA
CheckerManager manager = CheckerManager.getInstance();
manager.register(new YourChecker(),"your_LNG");
```

### Games
##### Word Chain
###### Start
```JAVA
WordGame game = WordsAPI.getNewWordGame(Your_Checker,countDown);
game.start();
game.input("player","word"); #returns WordGameCheckOut
/**
WordGameCheckOut
SUCCESS - There is nothing wrong
DOUBLE_WRITE - Last Player and Check Player same 
NOT_MATCH - Last and First letters not matches
USED - Word used
NOT_WORD - The word is not in the dictionary
ERROR - Game not started or game finished or word contains another characters
**/
```
###### Custom Finish 
```JAVA
WordGame game = getNewWordGame(IChecker,countDown,(results -> {
        //Your Code
}));
```
###### Contact-Discord: YmirSG#5599
