package ua.kpi.parsingText.model;

import ua.kpi.parsingText.view.Regex;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Evgeniy on 10.12.2016.
 */
public class WordFactory {
    private static final Map<String, Word> wordsMap = new HashMap<>();

    /**
     * This method filters creating same objects.
     * @param wordName
     * @return link to word
     */
    public Word getWord(String wordName){
        Word word = wordsMap.get(wordName);
        if (word == null){
            if ((wordName.charAt(wordName.length() - 1) + "").matches(Regex.TOKENS)) {
                wordName = wordName.substring(0, wordName.length() - 1);
            }
            word = new Word(wordName);
            wordsMap.put(wordName, word);
        }
        return word;
    }

    public static Map<String, Word> getWordsMap() {
        return wordsMap;
    }
}