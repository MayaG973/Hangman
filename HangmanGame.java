import java.util.ArrayList;
import java.util.Arrays;

public class HangmanGame {
    private final String[] wordList = {"health", "post", "employ", "kid", "unity", "threat", "run", 
    "enhance", "instrument", "west", "slay"};
    private ArrayList<String> remainingWords;
    private int wrongChoices;
    private String word;
    private String wordProgress = "";

    public HangmanGame() {
        remainingWords = new ArrayList<String>(Arrays.asList(wordList));
        wrongChoices = 0;
        int randNum = (int)(Math.random() * remainingWords.size());
        word = remainingWords.get(randNum);
    }

    public String getWord() {
        for (int i = 0; i < word.length(); i++)
        {
                wordProgress += "_ ";
        }
        System.out.println(word);
        return wordProgress;
    }

    public boolean checkLetter(String letter) {
        if (word.indexOf(letter) > -1)
        {
            while (word.indexOf(letter) > -1)
            {
                wordProgress = wordProgress.substring(0,word.indexOf(letter)) + letter + wordProgress.substring(word.indexOf(letter)+2);
                word = word.substring(0,word.indexOf(letter)) + wordProgress.substring(word.indexOf(letter)+1);
            }
            return true;
        }
        return false;
    }

    public String getWordProgress() {
        return wordProgress;
    }
 

}
